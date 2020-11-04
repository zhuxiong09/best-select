package com.zx.store.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登陆检查
public class LoginHandlerInterceptor implements HandlerInterceptor {

    HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
        //目标方法执行之前
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            Object user = request.getSession().getAttribute("loginUser");
            if (user == null) {
                //如果没有登录，返回登录界面；
                request.setAttribute("msg", "没有权限，请先登录！");
                request.getRequestDispatcher("/login").forward(request, response);
                return false;

            } else {
                // 如果登录，放行请求；

                return true;
            }
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
    };
}
