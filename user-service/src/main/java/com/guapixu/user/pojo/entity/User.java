package com.guapixu.user.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lizx
 */
@Data
public class User implements Serializable {
    private String uuid;
    private String name;
    private int age;
}
