package com.guapixu.user.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.guapixu.user.config.PatternProperties;
import com.guapixu.user.pojo.po.UserPO;
import com.guapixu.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lizx
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping("/user")
    public boolean saveUser(@RequestBody UserPO user){
        return userService.save(user);
    }

    @DeleteMapping("/user/{uuid}")
    public boolean removeUser(@PathVariable("uuid") String uuid){
        return userService.removeUser(uuid);
    }

    @PutMapping("/user")
    public boolean updateUser(@RequestBody UserPO user){
        if (StrUtil.isBlank(user.getUuid())){
            return false;
        }
        return userService.updateUser(user);
    }

    @GetMapping("/user/{uuid}")
    public UserPO findUser(@PathVariable("uuid") String uuid){
        return userService.getById(uuid);
    }
}
