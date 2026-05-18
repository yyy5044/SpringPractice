-- Database Schema for Book Management (with running_time for ResultMap practice)
DROP TABLE IF EXISTS book;

CREATE TABLE IF NOT EXISTS book (
    isbn VARCHAR(20) PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100),
    price INT DEFAULT 0,
    running_time INT COMMENT 'ResultMap 학습용 snake_case 컬럼',
    published_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Sample Data
INSERT INTO book (isbn, title, author, publisher, price, running_time, published_date) VALUES
('978-89-6848-001', 'Java 프로그래밍', '김싸피', '싸피출판', 35000, 120, '2022-01-15'),
('978-89-6848-002', 'Spring Boot 입문', '박싸피', '싸피출판', 45000, 90, '2023-03-20'),
('978-89-6848-003', 'MyBatis 입문 가이드', '이싸피', '미래북스', 32000, 60, '2022-06-10'),
('978-89-6848-004', 'JPA 활용', '박싸피', '싸피출판', 48000, 150, '2021-11-25'),
('978-89-6848-005', 'React 기초 가이드', '최싸피', '데브북스', 38000, 100, '2023-08-15'),
('978-89-6848-006', 'Vue.js 시작하기', '정싸피', '알고리즘북스', 29000, 80, '2022-09-01'),
('978-89-6848-007', 'JavaScript 기초 가이드', '데이브 싸피', '미래북스', 55000, 130, '2021-07-20'),
('978-89-6848-008', 'Good Code', '제임스 싸피', '테크출판', 33000, 110, '2020-05-10'),
('978-89-6848-009', 'Practical Java', '마이클 싸피', '테크출판', 36000, 95, '2022-04-18'),
('978-89-6848-010', 'SQL 기초 입문', '타나카 싸피', '미래북스', 22000, 70, '2021-02-28');
