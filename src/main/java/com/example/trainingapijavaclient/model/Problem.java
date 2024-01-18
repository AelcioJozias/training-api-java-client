package com.example.trainingapijavaclient.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Problem {

    private int status;
    private OffsetDateTime timeStamp;
    private String detail;
    private List<Fields> fields;

    @Getter
    @Setter
    public static class Fields {
        private String name;
        private String userMessage;

        @Override
        public String toString() {
            return "Fields{" +
                    "name='" + name + '\'' +
                    ", userMessage='" + userMessage + '\'' +
                    '}';
        }
    }
}
