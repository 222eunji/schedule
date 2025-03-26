# 📅 Schedule

## 0️⃣ 개요
### **프로젝트 개요**
- 일정관리 앱 서버를 만들었습니다.
- 원래 목표는 기본 CRUD 구현하기인데, 현재 Create 기능만 구현되어 있습니다.
- [프로젝트 회고 🖋️](https://aggeeeee.tistory.com/216 "트러블 슈팅 포함 상세 기록🖋️")
### **프로젝트기간**
- 2025-03-21 ~ 2025-03-26
### **개발 환경** 
- jdk: 17.0.1
- IDE : IntelliJ
- Framework: Spring


## 1️⃣ API명세 및 ERD 작성
### **📌 Schedule API 명세서**
| 기능 | Method | URL | request | response | 상태코드 |
| --- | --- | --- | --- | --- | --- |
| 일정 생성 | POST | /schedules | 요청 body   {   "content" : "할일",   "writer" : "작성자명",   "password" : "비밀번호"   }      ~"recordDate" : 작성일",~   ~"modifyDate" : "수정일"~   ~"scheduleID" :식별자ID"~       | 등록 정보   {   "scheduleID" : "식별자"   } | 200: 정상등록 |
| 전체 일정 조회 | GET | /schedules | 요청 param | 다건 응답 정보   \[    {   "modifyDate" : "수정일",   "name" : "작성자명"   }   \] | 200: 정상조회 |
| 선택 일정 조회 | GET | /schedules/{scheduleId} | 요청 param | 단건 응답 정보   {   "content" : "할일",   "name" : "작성자명",   "recordeDate" : "작성일"   } | 200: 정상조회 |
| 선택 일정 수정 | PUT | /schedules/{scheduleId} | 요청 body   {   "content" : "할일",   "name" : "작성자명",   "password" : "비밀번호"   } | 수정 정보   {   "content" : "할일",   "name" : "작성자명",   "recordeDate" : "수정일"   } | 200: 정상수정 |
| 선택 일정 삭제 | DELETE | /schedules/{scheduleId} | 요청 param   ~{~   ~"password" : "비밀번호"~   ~}~ | \- | 200: 정상삭제 |

### **📌 Schedule ERD**
![ERD](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbrQjA9%2FbtsMXwRqwb0%2FgXCOwH7AZm1r0bhoVyuTX0%2Fimg.png)

## 2️⃣ 기능 소개
### **🗨️ 일정 생성**
- 할일, 작성자명, 비밀번호, 작성/수정일 저장
- 작성/수정일은 날짜만 포함한 형태
- id(식별자)는 서버에서 형성
- 최초 입력 시 수정일은 작성일과 동일
- local DB로 데이터 저장

### **🗨️ 전체 일정 조회**
- 저장된 일정의 할일, 작성자명, 수정일 출력
- 📛 현재 단계에서는 DB연결 및 3Layer의 완전한 분리가 구현되어 있지 않습니다.

### **🗨️ 선택 일정 조회**
- 선택한 일정 단건의 정보를 조회
- id를 사용하여 일정을 선택한다.
- 📛 현재 단계에서는 DB연결 및 3Layer의 완전한 분리가 구현되어 있지 않습니다.

### **🗨️ 선택 일정 수정**
- id로 선택한 일정 할일, 작성자명 수정이 가능
- 일정 수정을 요청할 때 비밀번호 함께 전달 (일치 시 수정)
- 📛 현재 단계에서는 DB연결 및 3Layer의 완전한 분리가 구현되어 있지 않습니다.
- 📛 수정일 업데이트가 반영되어있지 않습니다.

### **🗨️ 선택 일정 삭제**
- id로 선택한 일정을 삭제
- 일정 삭제를 요청할 때 비밀번호 함께 전달
- 📛 현재 단계에서는 DB연결 및 3Layer의 완전한 분리가 구현되어 있지 않습니다.

## 3️⃣ 트러블 슈팅(티스토리 참고💥)
### 🔹[Level 1에서 발생](https://aggeeeee.tistory.com/216)   
- return시 ResponseEntity에 new를 붙이는 상황을 구분하지 못함
- ResponseDto와 RequestDto만으로 요청을 처리하려니 비효율적임
