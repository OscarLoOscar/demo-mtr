package com.bootcamp.demo_mtr.model.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_mtr.model.MtrDTO;
import com.bootcamp.demo_mtr.model.MtrDTO.LineDTO;
import com.bootcamp.demo_mtr.model.MtrDTO.StationDTO;
import com.bootcamp.demo_mtr.model.MtrDTO.TrainDTO;
import com.bootcamp.demo_mtr.model.TrainDataResponse;

@Component
public class Mapper {

    public MtrDTO map(TrainDataResponse trainDataResponse, String station) {
        if (trainDataResponse == null || trainDataResponse.getData() == null) {
            return MtrDTO.builder().build();
        }

        Map<String, TrainDataResponse.LineInfo> lineInfoMap = trainDataResponse.getData().getLineInfo();
        List<LineDTO> lines = lineInfoMap.entrySet().stream()
                .filter(entry -> entry.getKey().contains(station))
                .map(entry -> mapLine(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return MtrDTO.builder()
                .stations(List.of(StationDTO.builder()
                        .station(station)
                        .lines(lines)
                        .build()))
                .build();
    }

    LineDTO mapLine(String lineKey, TrainDataResponse.LineInfo lineInfo) {
        return LineDTO.builder()
                .line(lineKey.split("-")[0])
                .up(mapTrains(lineInfo.getUp()))
                .down(mapTrains(lineInfo.getDown()))
                .build();
    }

    List<TrainDTO> mapTrains(List<TrainDataResponse.Train> trains) {
        if (trains == null) {
            return null;
        }

        return trains.stream().map(this::mapTrain).collect(Collectors.toList());
    }

    TrainDTO mapTrain(TrainDataResponse.Train train) {
        if (train == null) {
            return null;
        }

        return TrainDTO.builder()
                .seq(train.getSeq())
                .dest(train.getDest())
                .plat(train.getPlat())
                .countDownTime(this.countTime(train.getTime()))
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
