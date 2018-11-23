package com.erp.zdyUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HandAdapterTest implements HandlerInterceptor{
    private static final Logger log = LoggerFactory.getLogger(Filter.class);
    /**
     * httpServletRequest存储请求信息，如ip地址,url等
     * preHandle进入Handler方法之前执行了，使用于身份认证，身份授权，登陆校验等，比如身份认证，用户没有登陆，
     * 拦截不再向下执行，返回值为 false ，即可实现拦截；否则，返回true时，拦截不进行执行
     * **/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ip = httpServletRequest.getRemoteAddr();
        String url = httpServletRequest.getRequestURI();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        log.info("时间:{},IP地址:{},目标URL:{}",time,ip,url);

        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");
        log.info("username:{}",username);
        if(username != null){
            return true;
        }else {
            httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }
    }

    /**
     * 进入Handler方法之后，返回ModelAndView之前执行，使用场景从ModelAndView参数出发，
     * 比如，将公用的模型数据在这里传入到视图，也可以统一指定显示的视图等
     * **/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在执行Handler完成后执行此方法，使用于统一的异常处理，统一的日志处理等
     * **/
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
