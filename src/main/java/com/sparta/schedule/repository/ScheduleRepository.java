package com.sparta.schedule.repository;

import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;

public interface ScheduleRepository {
    ScheduleResponseDto createScedule(Schedule schedule);


}
