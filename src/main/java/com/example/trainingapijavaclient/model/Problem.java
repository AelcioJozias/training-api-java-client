package com.example.trainingapijavaclient.model;

import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;

@Data
public class Problem {

    private int status;
    private OffsetDateTime timeStamp;
    private String detail;
}
