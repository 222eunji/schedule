package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long scheduleId;
    private String content;
    private String writer;
    private LocalDate recordDate;
    private LocalDate modifyDate;


    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.content = schedule.getContent();
        this.writer = schedule.getWriter();
        this.recordDate = schedule.getRecordDate();
        this.modifyDate = schedule.getModifyDate();
    }

}
