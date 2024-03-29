package com.guapixu.mail.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lizx
 */
@Data
@Component("mailProperties")
@ConfigurationProperties(prefix = "mail")
public class MailProperties {
    private String nick;
}
