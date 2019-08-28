package com.yuwendeng.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuwendeng.domain.ResultInfo;
import com.yuwendeng.domain.User;
import com.yuwendeng.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/userServlet/*")
public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserServiceImpl service = new UserServiceImpl();
        User u = service.login(user);
        ResultInfo info = new ResultInfo();
        //4判断用户名或者密码是否null
        if(u==null){
            //用户名或者密码错误
            info.setFlag(false);
            info.setData(u);
            info.setErrorMsg("用户名或者密码错误");
        }
        if(u!=null){
            info.setFlag(true);
            info.setData(u);
            info.setErrorMsg("登录成功");
        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("userservlet exit方法");
    }
}
