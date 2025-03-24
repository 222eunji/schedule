package com.sparta.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long scheduleId;
    private String content;
    private String writer;
    private String password;
    private LocalDate recordDate;
    private LocalDate modifyDate;

}
