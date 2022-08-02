package com.guapixu.user.pojo.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lizx
 */
@Data

public class UserPO implements Serializable {
    private String uuid;
    private String name;
    private int age;
}
