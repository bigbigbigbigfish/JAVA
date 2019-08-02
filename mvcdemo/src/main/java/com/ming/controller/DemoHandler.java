package com.ming.controller;


import com.ming.vo.UserInfo;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DemoHandler implements Controller {


    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {


        List<UserInfo> userInfoList = new ArrayList<UserInfo>();

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserid(1);
        userInfo1.setUsername("arvin");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserid(2);
        userInfo2.setUsername("arvin2");

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserid(3);
        userInfo3.setUsername("arvin3");

        userInfoList.add(userInfo1);
        userInfoList.add(userInfo2);
        userInfoList.add(userInfo3);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfoList",userInfoList);
        modelAndView.setViewName("showList");

        return modelAndView;
    }

    //xxx
    //xx
    //xxx
}
