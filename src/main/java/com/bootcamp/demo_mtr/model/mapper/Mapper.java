package com.bootcamp.demo_mtr.model.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_mtr.model.MtrDTO;
import com.bootcamp.demo_mtr.model.MtrDTO.TrainDTO;
import com.bootcamp.demo_mtr.model.TrainDataResponse;

@Component
public class Mapper {
  public MtrDTO map(TrainDataResponse trainDataResponse,String line ,String station) {
    if (trainDataResponse == null || trainDataResponse.getData() == null) {
      return MtrDTO.builder()//
      .build();
    }
String lineKey = this.concatLineAndStation(line, station);
    TrainDataResponse.LineInfo lineInfo = trainDataResponse.getData()
        .getLineInfo()//
        .get(lineKey);
        // .values().stream()//
        // .findFirst()//
        // .orElse(null);
    if (lineInfo == null) {
      return MtrDTO.builder().build();
    }

    return MtrDTO.builder()//
    .down(mapTrains(lineInfo.getDown()))//
        .up(mapTrains(lineInfo.getUp()))//
        .build();
  }

  List<TrainDTO> mapTrains(List<TrainDataResponse.Train> trains) {
    if (trains == null) {
      return null;
    }

    return trains.stream().map(this::map).collect(Collectors.toList());
  }

  TrainDTO map(TrainDataResponse.Train train) {
    // Optional.ofNullable(train).orElseThrow(()-> throw )
    if (train == null) {
      return null;
    }

    return TrainDTO.builder()//
        .seq(train.getSeq())//
        .dest(train.getDest())//
        .plat(train.getPlat())//
        .countDownTime(this.countTime(train.getTime()))//
        .build();
  }


  String countTime(String time) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime convertTime = LocalDateTime.parse(time,formatter);
    LocalDateTime convertSysTime = LocalDateTime.now(ZoneId.of("UTC+8"));
    int ans = convertTime.getMinute() - convertSysTime.getMinute();
    if (ans < 1)
      return String.valueOf("< 1");
    return String.valueOf(ans);
  }

  String concatLineAndStation(String line, String station) {
    return line.concat("-").concat(station);
  }
}
