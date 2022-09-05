package com.guapixu.user.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lizx
 */
@Data
@TableName("user")
public class UserPO implements Serializable {
    private String uuid;
    private String username;
    private String password;
    private String nickName;
    private int age;
    private String mobileNumber;
    private String email;
}
