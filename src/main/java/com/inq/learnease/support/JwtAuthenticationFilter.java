package com.inq.learnease.support;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

@Slf4j
@WebFilter(urlPatterns = "/api/*")
public class JwtAuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String token = httpRequest.getHeader("Authorization");

        if (token != null && token.equals("USER")) {
            log.info("인증완료");
            chain.doFilter(request, response);
        } else {
            log.info("인증실패");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}