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
public class TrainDataResponse {

    private int status;
    private String message;
    @JsonProperty("sys_time")
    private String sysTime;

    @JsonProperty("curr_time")
    private String currTime;
    private Data data;
    private String isDelay;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    public static class Data {
        private Map<String, LineInfo> lineInfo;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    public static class LineInfo {
        @JsonProperty("curr_time")
        private String currTime;

        @JsonProperty("sys_time")
        private String sysTime;
        private List<Train> down;
        private List<Train> up;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    public static class Train {
        private String seq;
        private String dest;
        private String plat;
        private String time;
        private String ttnt;
        private String valid;
        private String source;

    }
}
