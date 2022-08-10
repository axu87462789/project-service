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
    private String dateFormat;
}
