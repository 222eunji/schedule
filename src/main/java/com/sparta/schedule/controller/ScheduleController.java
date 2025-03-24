package com.sparta.schedule.controller;

import com.sparta.schedule.dto.SchedulePasswordDto;
import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    // 일정 생성
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

    // 전체 일정 조회
    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules() {

        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for (Schedule schedule : scheduleList.values()) {
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }

        // 조건에 따라 조회하기-모르겠음
        // 수정일 기준 내림차순 정렬은 put 메서드 생성 후 추가하기

        return responseList;

    }

    // 선택 일정 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleByID(@PathVariable Long id) {

        Schedule schedule = scheduleList.get(id);

        return new ScheduleResponseDto(schedule);

    }

    // 선택 일정 수정
    @PatchMapping("/{id}")
    public ScheduleResponseDto updateScheduleByID(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto){

        Schedule schedule = scheduleList.get(id);

        schedule.update(requestDto);

        return new ScheduleResponseDto(schedule);

    }

    // 선택 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(
            @PathVariable Long id,
            @RequestBody SchedulePasswordDto request) {

        Schedule schedule = scheduleList.get(id);

        if (schedule == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("일정을 찾을 수 없습니다.");
        }

        if (!schedule.getPassword().equals(request.getPassword())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
        }

        scheduleList.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("일정이 삭제되었습니다.");

    }

}
