package com.yuqiqi.growup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuyunbo on 2019/4/27.
 */
@Controller
@RequestMapping("/htmlController")
public class HtmlController {

    @RequestMapping("/getHtml")
    public Object getHtml(){
        return "hello";
    }
}
