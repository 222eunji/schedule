package com.sparta.schedule.entity;

import com.sparta.schedule.dto.ScheduleRequestDto;
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

    public void update(ScheduleRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
    }

    public void updateContent(ScheduleRequestDto dto) {
        this.content = dto.getContent();
    }

    public void updateWriter(ScheduleRequestDto dto) {
        this.writer = dto.getWriter();
    }
}