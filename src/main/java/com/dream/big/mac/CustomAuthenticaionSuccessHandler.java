package com.dream.big.mac;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/14 0:24
 */
public class CustomAuthenticaionSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public CustomAuthenticaionSuccessHandler(String defaultTargetUrl) {
        this.setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        response.sendRedirect(getDefaultTargetUrl());
    }

}
