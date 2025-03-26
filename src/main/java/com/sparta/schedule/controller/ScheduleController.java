package com.sparta.schedule.controller;

import com.sparta.schedule.dto.SchedulePasswordDto;
import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

//    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto) {

        return new ResponseEntity<>(scheduleService.createSchedule(dto), HttpStatus.CREATED) ;

    }

    // 조회,수정,삭제는 3 Layer로 분리하지 못하여 동작이 되지않아 주석처리 했습니다 ㅠ.ㅠ
//    // 전체 일정 조회
//    @GetMapping
//    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules() {
//
//        List<ScheduleResponseDto> responseList = new ArrayList<>();
//
//        for (Schedule schedule : scheduleList.values()) {
//            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
//            responseList.add(responseDto);
//        }
//
//        // 조건에 따라 조회하기-모르겠음
//        // 수정일 기준 내림차순 정렬은 put 메서드 생성 후 추가하기
//
//        return new ResponseEntity<>(responseList, HttpStatus.OK);
//
//    }
//
//    // 선택 일정 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<ScheduleResponseDto> findScheduleByID(@PathVariable Long id) {
//
//        Schedule schedule = scheduleList.get(id);
//
//        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
//
//    }
//
//    // 선택 일정 수정 - content
//    @PatchMapping("/{id}")
//    public ResponseEntity<ScheduleResponseDto> updateScheduleByID(
//            @PathVariable Long id,
//            @RequestBody ScheduleRequestDto requestDto){
//
//        Schedule schedule = scheduleList.get(id);
//
//        // NPE 방지
//        if (schedule == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        // 비밀번호 검증
//        if (!schedule.getPassword().equals(requestDto.getPassword())){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//
//        // 입력된 값만 업데이트
//        if (requestDto.getContent() != null){
//            schedule.updateContent(requestDto);
//        }
//
//        if (requestDto.getWriter() != null){
//            schedule.updateWriter(requestDto);
//        }
//
//        // 수정일 업데이트 - DB연결하고 도전
//
//        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK) ;
//
//    }
//
//    // 선택 일정 삭제
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteSchedule(
//            @PathVariable Long id,
//            @RequestBody SchedulePasswordDto request) {
//
//        Schedule schedule = scheduleList.get(id);
//
//        if (schedule == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("일정을 찾을 수 없습니다.");
//        }
//
//        if (!schedule.getPassword().equals(request.getPassword())){
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
//        }
//
//        scheduleList.remove(id);
//        return ResponseEntity.status(HttpStatus.OK).body("일정이 삭제되었습니다.");
//
//    }

}
