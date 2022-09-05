package com.guapixu.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lizx
 */
@Data
@Component("patternProperties")
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    /**
     * redisKey前缀 项目+业务
     */
    private String redisKeyPrefix;

    /**
     * 统一时间格式
     */
    private String dateFormat;

    /**
     * 登录邮箱验证邮件标题
     */
    private String loginCodeMailSubject;
}
