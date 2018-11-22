package com.erp.zdyUtils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class filterTest implements Filter {
    private static final Logger log = LoggerFactory.getLogger(Filter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("测试异常");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String ip = httpServletRequest.getRemoteAddr();
        String url = httpServletRequest.getRequestURI();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        log.info("时间:{},IP地址:{},目标URL:{}",time,ip,url);
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    @Override
    public void destroy() {
    }
}
