package com.bootcamp.demo_mtr.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
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
  private List<TrainDTO> down;
  private List<TrainDTO> up;

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
