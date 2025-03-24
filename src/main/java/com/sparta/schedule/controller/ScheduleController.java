package com.sparta.schedule.controller;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {

        // 식별자가 1씩 증가
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet())+ 1;

        // 현재 날짜 작성
        LocalDate now = LocalDate.now();

        // 요청받은 데이터로 Schedule 객체 생성
        Schedule schedule = new Schedule(scheduleId, dto.getContent(), dto.getWriter(), dto.getPassword(), now, now);

        //Inmemory DB에 저장
        scheduleList.put(scheduleId, schedule);

        return new ScheduleResponseDto(schedule);

    }
}
