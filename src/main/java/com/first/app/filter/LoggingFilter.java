package com.first.app.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Slf4j
@Component
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(httpServletResponse);
        filterChain.doFilter(contentCachingRequestWrapper, contentCachingResponseWrapper);
        String request = getStringValue(contentCachingRequestWrapper.getContentAsByteArray(), httpServletRequest.getCharacterEncoding());
        String response = getStringValue(contentCachingResponseWrapper.getContentAsByteArray(), httpServletResponse.getCharacterEncoding());
        System.out.println("Request Filter:-->"+request);
        System.out.println("Response Filter:-->"+response);
    }

    private String getStringValue(byte[] byteArray, String encoding) throws UnsupportedEncodingException {
        return new String(byteArray, 0, byteArray.length, encoding);
    }


}
