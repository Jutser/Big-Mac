package com.dream.big.mac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/11 23:59
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }
}
