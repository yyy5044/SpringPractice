package com.ssafy.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DataService {

    /**
     * 빠른 조회 (100ms 미만)
     */
    public List<String> quickQuery() {
        System.out.println("DataService.quickQuery() 실행됨");
        List<String> result = new ArrayList<>();
        result.add("Data1");
        result.add("Data2");
        result.add("Data3");
        return result;
    }

    /**
     * 느린 작업 (1초 이상)
     */
    public String generateReport() {
        System.out.println("DataService.generateReport() 실행됨");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Report-" + System.currentTimeMillis();
    }
}
