package com.cao.springmvc.contorller;

import com.cao.springmvc.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItemContorller {
    // .action可以省略  (请求的url地址)
    @RequestMapping("/itemList.action")
    public ModelAndView itemList() {
        // 查询商品列表，使用静态数据生成一个商品列表
        List<Items> itemList = new ArrayList<Items>();
        itemList.add(new Items(1, "imac", 20000, new Date(), "苹果本很贵"));
        itemList.add(new Items(2, "imac1", 20000, new Date(), "苹果本很贵"));
        itemList.add(new Items(3, "imac2", 20000, new Date(), "苹果本很贵"));
        itemList.add(new Items(4, "imac3", 20000, new Date(), "苹果本很贵"));
        itemList.add(new Items(5, "imac4", 20000, new Date(), "卧槽，苹果本很贵啦！"));
        // 把商品列表传递给jsp
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", itemList);
        // 设置展示数据的视图，即jsp
        modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
        // 返回结果
        return modelAndView;
    }
}
