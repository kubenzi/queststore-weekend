package com.codecool.fusy_qs.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * in this case I have used httpServletRequest.getSession(false) - because I wanted to check if there is current
     * session - so I don't want to create a new one
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(false);
        if (session == null || session.getAttribute("student") == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/loginForm");
        } else if (session == null || session.getAttribute("mentor") == null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/loginForm");
        }else{
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
