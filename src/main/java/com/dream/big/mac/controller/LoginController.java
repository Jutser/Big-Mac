package com.dream.big.mac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/14 16:05
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }
}
