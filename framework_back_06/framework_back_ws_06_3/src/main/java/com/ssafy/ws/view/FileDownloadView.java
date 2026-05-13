package com.ssafy.ws.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 파일 다운로드 전용 View
 * - AbstractView를 상속하여 renderMergedOutputModel()에서 파일을 스트리밍한다.
 * - BeanNameViewResolver에 의해 "fileDownloadView"라는 이름으로 매핑된다.
 */
@Component("fileDownloadView")
public class FileDownloadView extends AbstractView {

    public FileDownloadView() {
        setContentType("application/download; charset=utf-8");
    }

    /**
     * TODO: 파일 다운로드 렌더링을 구현하세요.
     *
     * model에서 "downloadFile"(File)과 "originalFilename"(String)을 꺼내어
     * 응답 헤더를 설정하고 파일 데이터를 OutputStream으로 전송합니다.
     *
     * 1. model에서 다운로드할 File 객체와 원본 파일명을 꺼낸다.
     * 2. Content-Type, Content-Length, Content-Disposition, Content-Transfer-Encoding 헤더를 설정한다.
     * 3. FileInputStream과 OutputStream을 사용하여 파일을 전송한다.
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        // TODO: 파일 다운로드 로직을 구현하세요
    	// 1. model에서 파일 정보 꺼내기
    	File file = (File) model.get("downloadFile");
    	String originalFileName = (String) model.get("originalFilename");
    	
    	// 2. 응답 헤더 설정 (브라우저에게 "이건 다운로드할 파일이야"라고 알려주기)
    	response.setContentType("application/octet-stream");
    	response.setContentLengthLong(file.length());
    	response.setHeader("Content-Disposition", 
    							"attachment; filename=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\"") ;
        response.setHeader("Content-Transfer-Encoding", "binary");
        
        // 3. 파일 읽어서 전송
        try (FileInputStream fis = new FileInputStream(file);
             OutputStream os = response.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        }
    }
}
