-- Database Schema for Movie Management
DROP TABLE IF EXISTS movie;

CREATE TABLE IF NOT EXISTS movie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    director VARCHAR(100) NOT NULL,
    genre VARCHAR(50),
    running_time INT COMMENT '상영시간(분)',
    release_year INT,
    rating DECIMAL(3,1) COMMENT '평점(0.0~10.0)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Sample Data
INSERT INTO movie (title, director, genre, running_time, release_year, rating) VALUES
('공생의 법칙', '장싸피', '드라마', 132, 2019, 9.2),
('서울 탈출', '한싸피', '액션', 118, 2016, 8.5),
('복수의 시간', '윤싸피', '스릴러', 120, 2003, 8.8),
('한강의 그림자', '장싸피', '공포', 119, 2006, 8.1),
('기억의 조각', '장싸피', '스릴러', 132, 2003, 8.5),
('강철전사', '톰 싸피', '액션', 126, 2008, 8.0),
('영웅연합', '마크 싸피', '액션', 143, 2012, 8.5),
('꿈의 설계자', '알렉스 싸피', 'SF', 148, 2010, 9.0),
('별의 항해', '알렉스 싸피', 'SF', 169, 2014, 9.1),
('어둠의 수호자', '알렉스 싸피', '액션', 152, 2008, 9.0),
('별빛 아래서', '폴 싸피', '뮤지컬', 128, 2016, 8.8),
('광대의 눈물', '닉 싸피', '드라마', 122, 2019, 8.6),
('바다의 약속', '데이빗 싸피', '로맨스', 194, 1997, 8.7),
('푸른 행성', '데이빗 싸피', 'SF', 162, 2009, 8.3),
('가상현실', '싸피 브라더스', 'SF', 136, 1999, 9.0);
