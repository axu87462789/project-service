package com.guapixu.user.controller;

import cn.hutool.core.util.IdUtil;
import com.guapixu.user.config.PatternProperties;
import com.guapixu.user.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizx
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PatternProperties patternProperties;

    @GetMapping("user")
    public User findUser(){
        User user = new User();
        user.setAge(18);
        user.setName("阿嘘");
        user.setUuid(IdUtil.fastSimpleUUID());
        System.out.println(patternProperties.getDateFormat());
        System.out.println(patternProperties.getSharedValue());
        return user;
    }
}
