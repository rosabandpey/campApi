package com.camp.campApi.exception;

import com.camp.campApi.entity.ResponseApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);


    @Autowired
    ObjectMapper mapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        logger.error("Unauthorized error. Message - {}", accessDeniedException.getMessage());
        ServletServerHttpResponse res = new ServletServerHttpResponse(response);
        res.setStatusCode(HttpStatus.FORBIDDEN);
        res.getServletResponse().setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        res.getBody().write(mapper.writeValueAsString(new ResponseApi(false,  accessDeniedException.getMessage(), new Date().toString(), null)).getBytes());

}
}
