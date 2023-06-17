package com.matheus.beicinhofoodapi.api.exceptionHandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Builder
public class Problem {

    private Integer status;
    private String type;
    private String title;
    private String detail;

    private String userMessage;
    private OffsetDateTime timeStamp;
    private List<Object> objects;

    @Getter
    @Builder
    public static  class Object {
        private String name;
        private String userMessage;
    }

}
