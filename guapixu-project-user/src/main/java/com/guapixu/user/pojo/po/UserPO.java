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
    private String name;
    private int age;
}
