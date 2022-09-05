package com.guapixu.user.service;

import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.user.pojo.vo.LoginVO;

/**
 * @author lizx
 * @since 2022-08-02
 */
public interface LoginService {
    /**
     * 发送邮箱验证码邮件
     * @param loginVO 邮箱信息
     * @return 发送结果
     */
    void sendMailCode(LoginVO loginVO);

    /**
     * 邮箱验证码登录
     * @param loginVO 邮箱及验证码信息
     * @return 登入结果
     */
    ResultVO<?> loginMailCode(LoginVO loginVO);
}
