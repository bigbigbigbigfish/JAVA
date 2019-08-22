package com.cao.springmvc.control;

import com.cao.springmvc.service.impl.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
public class HelloWorldCoroller {

    @Autowired
    private HelloWorldService helloWorldService;

    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        Map<String,String> info =new HashMap<String, String>();
        info.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        modelAndView.addAllObjects(info);
        return modelAndView;

    }


}
