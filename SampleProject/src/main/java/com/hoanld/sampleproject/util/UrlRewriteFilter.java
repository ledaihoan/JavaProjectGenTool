package com.hoanld.sampleproject.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlRewriteFilter implements Filter {
    private static final Pattern REWRITE_PATTERN = Pattern.compile(".*-(\\d*).html$", Pattern.DOTALL);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper((HttpServletRequest) request);
        String url = wrapper.getRequestURL().toString();
        Matcher m = REWRITE_PATTERN.matcher(url);
        if (m.find()) {
            String str = m.group(1);
            long id = Long.parseLong(str) * 10;
            RequestDispatcher dispatcher = wrapper.getRequestDispatcher("/home?id=" + id);
            dispatcher.forward(request, response);
        } else {
            chain.doFilter(wrapper, response);
        }
    }

    @Override
    public void destroy() {

    }
}
