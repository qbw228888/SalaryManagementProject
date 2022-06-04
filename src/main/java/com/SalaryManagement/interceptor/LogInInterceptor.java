package com.SalaryManagement.interceptor;

import com.SalaryManagement.Domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //得到用户请求的URL
        String request_uri=request.getRequestURI();
        //得到web应用程序的上下文路径
        String ctxPath=request.getContextPath();
        //去除上下文路径，得到剩余路径
        String uri=request_uri.substring(ctxPath.length());
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
        //登陆页面或servlet不拦截
            if(uri.contains("login") || uri.contains("index") || uri.contains("register")) {
                return true;
            } else{
                response.sendRedirect(request.getContextPath()+"/login");
                return false;
            }
        } else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
