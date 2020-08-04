package com.memory.Journal.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialised");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("DoFilter initialised");
        System.out.println("Request Address is " + request.getRemoteAddr() + " host is " + request.getRemoteHost());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroying");
    }
}
