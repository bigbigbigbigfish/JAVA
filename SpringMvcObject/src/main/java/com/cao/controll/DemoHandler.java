package com.cao.controll;

import com.cao.vo.UserInfo;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

public class DemoHandler implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        /**
         *  1, 获取表单参数 null
         *  2，调用业务逻辑 模拟*
         *  3，转向        模拟*
         */
        List<UserInfo> userInfoArrayList = new ArrayList<UserInfo>();
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserId(1);
        userInfo1.setUserName("arvin");
        userInfo1.setPassword("123");


        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserId(2);
        userInfo2.setUserName("arvin2");
        userInfo2.setPassword("123");

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserId(3);
        userInfo3.setUserName("arvin3");
        userInfo3.setPassword("123");

        userInfoArrayList.add(userInfo1);
        userInfoArrayList.add(userInfo2);
        userInfoArrayList.add(userInfo3);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userInfoArrayList);
        modelAndView.setViewName("showList");

        return modelAndView;
    }
}
