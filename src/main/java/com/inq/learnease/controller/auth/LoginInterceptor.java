/*
package com.inq.learnease.controller.auth;

import com.inq.learnease.support.AuthorizationExtractor;
import com.inq.learnease.support.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    
    private final JwtTokenProvider jwtTokenProvider;
    
    public LoginInterceptor(final JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object handler) {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        final String token = AuthorizationExtractor.extract(request);
        jwtTokenProvider.validateAbleToken(token);
        return true;
    }
}
*/
