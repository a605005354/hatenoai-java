package com.cmy.hatenojava.config.intercepter;

import com.cmy.hatenojava.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.config.intercepter
 * @className: JwtAuthenticationFilter
 * @author: Terry Cai
 * @description: Auth Filter for JWT
 * @date: 3/6/24 2:51 PM
 * @version: 1.0
 */

public class JwtAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String token = httpRequest.getHeader("Authorization");
        if (token != null && !token.isEmpty()) {
            try {
                String user = JwtUtils.validateTokenAndRetrieveSubject(token.replace("Bearer ", ""));
                // You can then use the user information for further authentication/authorization
            } catch (RuntimeException e) {
                // Handle invalid token, e.g., throw an exception or send an error response
            }
        }
        chain.doFilter(request, response);
    }
}
