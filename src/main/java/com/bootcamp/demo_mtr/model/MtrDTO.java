package com.bootcamp.demo_mtr.model;

import java.util.List;
import java.util.Map;
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
      @JsonProperty("sys_time")
    private String sysTime;

    @JsonProperty("curr_time")
    private String currTime;
    
    private DataDTO data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    public static class DataDTO{
              private Map<String, LineInfoDTO> lineInfo;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    public static class LineInfoDTO{
        @JsonProperty("curr_time")
        private String currTime;

        @JsonProperty("sys_time")
        private String sysTime;
        private List<TrainDTO> down;
        private List<TrainDTO> up;

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
      private String time;
      private String ttnt;
      private String valid;
      private String source;

  }

}
