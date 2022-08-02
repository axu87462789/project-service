package com.guapixu.user.controller;

import cn.hutool.core.util.IdUtil;
import com.guapixu.user.config.PatternProperties;
import com.guapixu.user.pojo.po.UserPO;
import com.guapixu.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lizx
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "patternProperties")
    private PatternProperties patternProperties;

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("user")
    public UserPO findUser(){
        UserPO user = new UserPO();
        user.setAge(18);
        user.setName("阿嘘");
        user.setUuid(IdUtil.fastSimpleUUID());
        System.out.println(patternProperties.getDateFormat());
        System.out.println(patternProperties.getSharedValue());
        return user;
    }
}
