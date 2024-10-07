package com.bootcamp.demo_mtr.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_mtr.infra.ApiUtil;
import com.bootcamp.demo_mtr.model.Line;
import com.bootcamp.demo_mtr.model.MtrDTO;
import com.bootcamp.demo_mtr.model.Station;
import com.bootcamp.demo_mtr.model.TrainDataResponse;
import com.bootcamp.demo_mtr.model.mapper.Mapper;
import com.bootcamp.demo_mtr.model.mapper.StationLineMapper;
import com.bootcamp.demo_mtr.service.MTRService;

@Service // Bean
public class MTRServiceImpl implements MTRService {

  @Autowired
  private Mapper mapper;

  @Autowired
  private ApiUtil apiUtil;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private StationLineMapper stationLineMapper;

  public MtrDTO getTime(String line, String station) {
    TrainDataResponse trainDataResponse = restTemplate
        .getForObject(apiUtil.getUrl(line, station), TrainDataResponse.class);
    return mapper.map(trainDataResponse, station);
  }

  @Override
  public MtrDTO getTime(String station) {
    Station stationEnum = Station.valueOf(station);

    List<Line> lines = stationLineMapper.getLinesForStation(stationEnum);

    if (lines.isEmpty())
      throw new UnsupportedOperationException(
          "No lines found for the given station : " + station);

    List<MtrDTO> lineStas = lines.stream()//
        .map(line -> {
          return this.getTime(line.name(), station);
        })//
        .collect(Collectors.toList());

    return this.mergeMtrDTOs(lineStas, station);
  }

  private MtrDTO mergeMtrDTOs(List<MtrDTO> lineEtas, String station) {
    return MtrDTO.builder()//
        .stations(List.of(MtrDTO.StationDTO.builder()//
            .station(station)//
            .lines(lineEtas.stream()//
                .flatMap(dto -> dto.getStations().stream()//
                    .flatMap(stationDTO -> stationDTO.getLines().stream()))//
                .collect(Collectors.toList()))//
            .build()))//
        .build();//
  }



}
