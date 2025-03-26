package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;

public interface ScheduleService {

    ScheduleResponseDto createSchedule(ScheduleRequestDto dto);

}
