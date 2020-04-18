package com.drawdream.app.base.interceptor;

import lombok.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @desc: 跨域解决类
 * @package: com.drawdream.app.base.Interceptor
 * @fileName: CorsFilter
 * @author: tanhao
 * @date: 2020-04-18 16:02
 */
@Component
@WebFilter
@Order(Integer.MIN_VALUE)
public class CorsFilter implements Filter {


    private static final String PARAMS_SEPARATE = "http://localhost:8081, ";

//    @Value(staticConstructor = "${cors.access.control.maxAge:7200}")
    String corsAccessControlMaxAge = "7200";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = ((HttpServletResponse) servletResponse);

        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, httpServletRequest.getHeader(HttpHeaders.ORIGIN));
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, getHeaders(httpServletRequest));
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, corsAccessControlMaxAge);
        httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, httpServletRequest.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD));
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());

        } else {
            httpServletResponse.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, httpServletRequest.getMethod());
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    private String getHeaders(HttpServletRequest httpServletRequest) {
        StringBuilder params = new StringBuilder();
        String accessControlRequestHeaders = httpServletRequest.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS);
        if (!(accessControlRequestHeaders == null || accessControlRequestHeaders.isEmpty())) {
            params.append(accessControlRequestHeaders).append(PARAMS_SEPARATE);
        }

        Enumeration<String> names = httpServletRequest.getHeaderNames();
        while (names.hasMoreElements()) {
            params.append(names.nextElement()).append(PARAMS_SEPARATE);
        }
        params.setLength(params.length() - PARAMS_SEPARATE.length());
        return params.toString();
    }

    @Override
    public void destroy() {

    }
}
