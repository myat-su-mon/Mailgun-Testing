package com.example.democustomfilter1.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationLoggerFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(AuthenticationLoggerFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) servletRequest;
        String requestId = httpRequest.getHeader("Request-Id");
        logger.info("Successfully authenticated request with id : " + requestId);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
