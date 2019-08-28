package com.yuwendeng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/faggag")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        //请求路径
        String path = request.getRequestURI();
        System.out.println(path);
        //获取session中作为判断的关键字
        String pwd = (String) session.getAttribute("passwd");
        //判断是否包含登录页面的请求,则放行
        if(path.indexOf("/userServlet/login")>-1){
            chain.doFilter(request, response);
        }else{//如果没有则，判断是否有session中的标志，没有则不让访问页面，让他去登录，反之放行
            if(pwd==null||"".equals(pwd)){
                response.sendRedirect("/login.jsp");
            }else{
                chain.doFilter(request, response);
            }

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
