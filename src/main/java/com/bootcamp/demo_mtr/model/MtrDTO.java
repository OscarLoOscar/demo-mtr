package com.bootcamp.demo_mtr.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MtrDTO {
  private List<StationDTO> stations;

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @ToString
  @Builder
  public static class StationDTO {
    private String station;
    private List<LineDTO> lines;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @ToString
  @Builder
  public static class LineDTO {
    private String line;
    private List<TrainDTO> up;
    private List<TrainDTO> down;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @ToString
  @Builder
  public static class TrainDTO {
    private String seq;
    private String dest;
    private String plat;
    private String countDownTime;
  }
}
