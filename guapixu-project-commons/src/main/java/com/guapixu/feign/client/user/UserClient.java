package com.guapixu.feign.client.user;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lizx
 */
@FeignClient(value = "guapixu-project-user")
public interface UserClient {
}
