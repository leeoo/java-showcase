package com.lex.showcase.web.servlet3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 */
@WebFilter(urlPatterns = "/filter", asyncSupported = true)
public class AsyncDemoFilter implements Filter {
    private static Logger log = LogManager.getLogger(AsyncDemoFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init filter...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
