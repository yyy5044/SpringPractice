-- Database Schema for Movie Management
DROP TABLE IF EXISTS movie;

CREATE TABLE IF NOT EXISTS movie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    director VARCHAR(100) NOT NULL,
    genre VARCHAR(50),
    running_time INT COMMENT '상영시간(분)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Sample Data
INSERT INTO movie (title, director, genre, running_time) VALUES
('공생의 법칙', '장싸피', '드라마', 132),
('서울 탈출', '한싸피', '액션', 118),
('복수의 시간', '윤싸피', '스릴러', 120),
('한강의 그림자', '장싸피', '공포', 119),
('기억의 조각', '장싸피', '스릴러', 132),
('강철전사', '톰 싸피', '액션', 126),
('영웅연합', '마크 싸피', '액션', 143),
('꿈의 설계자', '알렉스 싸피', 'SF', 148),
('별의 항해', '알렉스 싸피', 'SF', 169),
('어둠의 수호자', '알렉스 싸피', '액션', 152),
('별빛 아래서', '폴 싸피', '뮤지컬', 128),
('광대의 눈물', '닉 싸피', '드라마', 122),
('바다의 약속', '데이빗 싸피', '로맨스', 194),
('푸른 행성', '데이빗 싸피', 'SF', 162),
('가상현실', '싸피 브라더스', 'SF', 136);
