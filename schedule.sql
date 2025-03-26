CREATE TABLE schedule
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '식별자',
    content VARCHAR(300) NOT NULL COMMENT '일정내용',
    record_date DATE COMMENT '작성일',
    modify_date DATE COMMENT '수정일',
    writer VARCHAR(50) COMMENT '작성자',
    password VARCHAR(50) COMMENT '비밀번호'
)