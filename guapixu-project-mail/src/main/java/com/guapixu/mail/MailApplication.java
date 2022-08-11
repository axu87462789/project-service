package com.guapixu.mail;

import com.guapixu.feign.config.DefaultFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lizx
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.guapixu.feign.client.user"}, defaultConfiguration = DefaultFeignConfiguration.class)
@ComponentScan("com.guapixu")
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
    }
}
