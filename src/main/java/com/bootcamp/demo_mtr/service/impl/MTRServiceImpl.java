package com.bootcamp.demo_mtr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_mtr.infra.ApiUtil;
import com.bootcamp.demo_mtr.model.MtrDTO;
import com.bootcamp.demo_mtr.model.TrainDataResponse;
import com.bootcamp.demo_mtr.model.mapper.Mapper;
import com.bootcamp.demo_mtr.service.MTRService;

@Service // Bean
public class MTRServiceImpl implements MTRService {

  @Autowired
  private Mapper mapper;

  @Autowired
  private ApiUtil apiUtil;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public MtrDTO getTime(String line, String station) {
    TrainDataResponse trainDataResponse = restTemplate
        .getForObject(apiUtil.getUrl(line, station), TrainDataResponse.class);
        System.out.println(trainDataResponse);
    return mapper.map(trainDataResponse,line,station);
  }
}
