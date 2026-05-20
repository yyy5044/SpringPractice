package com.ssafy.hw.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.hw.model.dto.Movie;

/**
 * 영화 Dao 인터페이스
 *
 * TODO: MovieMapper.xml에 각 메서드에 대응하는 SQL을 구현하세요.
 */
@Mapper
public interface MovieDao {

    /**
     * 전체 영화 목록 조회
     */
    List<Movie> selectAll();

    /**
     * ID로 영화 조회
     */
    Movie findById(@Param("id") int id);

    /**
     * TODO 1: 제목으로 검색 (<if> 태그 사용)
     *
     * - title이 null이거나 빈 문자열이면 전체 조회
     * - title이 있으면 LIKE 검색 (부분 일치)
     *
     * @param title 검색할 제목
     * @return 검색된 영화 목록
     */
    List<Movie> searchByTitle(@Param("title") String title);

    /**
     * TODO 2: 감독으로 검색 (<if> 태그 사용)
     *
     * - director가 null이거나 빈 문자열이면 전체 조회
     * - director가 있으면 LIKE 검색 (부분 일치)
     *
     * @param director 검색할 감독명
     * @return 검색된 영화 목록
     */
    List<Movie> searchByDirector(@Param("director") String director);

    /**
     * TODO 3: 타입별 검색 (<choose>, <when>, <otherwise> 태그 사용)
     *
     * searchType에 따라 검색 대상 필드 결정:
     * - "title": 제목에서 검색
     * - "director": 감독에서 검색
     * - "genre": 장르에서 검색 (정확히 일치)
     * - 그 외: 제목 또는 감독에서 검색
     *
     * @param searchType 검색 타입
     * @param keyword 검색 키워드
     * @return 검색된 영화 목록
     */
    List<Movie> searchByType(@Param("searchType") String searchType,
                             @Param("keyword") String keyword);

    /**
     * TODO 4: 정렬 옵션 포함 검색 (<if> + <choose> 조합)
     *
     * - keyword가 있으면 제목 또는 감독에서 검색
     * - orderBy로 정렬 기준 선택: title, director, rating, runningTime, releaseYear
     * - orderDir로 정렬 방향 선택: asc, desc
     *
     * @param keyword 검색 키워드
     * @param orderBy 정렬 기준
     * @param orderDir 정렬 방향
     * @return 검색된 영화 목록
     */
    List<Movie> searchWithSort(@Param("keyword") String keyword,
                               @Param("orderBy") String orderBy,
                               @Param("orderDir") String orderDir);
}
