package com.ming.controller;


import com.ming.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoHandler3 {

    @RequestMapping("/queryUserInfo.action")
    public ModelAndView queryUserInfo(){

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

}
