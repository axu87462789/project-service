package com.guapixu.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guapixu.user.pojo.po.UserPO;

import java.util.List;

/**
 * @author lizx
 * @since 2022-08-02
 */
public interface UserService extends IService<UserPO> {
    /**
     * 通过邮箱新增用户信息
     * @param email 邮箱
     * @return 用户信息
     */
    UserPO saveUserWithEmail(String email);

    /**
     * 删除用户信息
     * @param uuid 用户uuid
     * @return 删除结果
     */
    boolean removeUser(String uuid);

    /**
     * 更改用户信息
     * @param user 用户信息
     * @return 更改结果
     */
    boolean updateUser(UserPO user);

    /**
     * 查询用户信息
     * @param uuid 用户uuid
     * @return 用户信息
     */
    UserPO getUser(String uuid);

    /**
     * 批量查询用户信息
     * @param uuidList 用户uuid
     * @return 用户信息
     */
    List<UserPO> listUsers(List<String> uuidList);
}
