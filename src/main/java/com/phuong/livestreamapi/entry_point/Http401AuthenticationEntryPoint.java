package com.phuong.livestreamapi.entry_point;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class Http401AuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final String headerValue;

    public Http401AuthenticationEntryPoint(String headerValue) {
        this.headerValue = headerValue;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setHeader("WWW-Authenticate", this.headerValue);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                authException.getMessage());
    }

}