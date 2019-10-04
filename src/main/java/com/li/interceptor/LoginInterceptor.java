package com.li.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        if (!(uri.contains("login") || uri.contains("Login") || uri.contains("register"))) {
            if (request.getSession().getAttribute("user") != null) {
                return true;
            } else {
                if (uri.contains("css") || uri.contains("js") || uri.contains("images")) {
                    return true;
                } else {
                    response.sendRedirect(request.getContextPath() + "/user/toLogin.action" );
                }
            }

        } else {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
