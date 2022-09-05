package com.guapixu.user.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guapixu.user.dao.UserDao;
import com.guapixu.user.pojo.po.UserPO;
import com.guapixu.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizx
 * @since 2022-08-02
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserPO> implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserPO saveUserWithEmail(String email) {
        UserPO user = new UserPO();
        user.setUuid(IdUtil.fastSimpleUUID());
        user.setEmail(email);
        user.setNickName(RandomUtil.randomString(8));
        Integer count;
        // 生成不重复随机用户名
        do {
            user.setUsername(RandomUtil.randomString(10));
            count = lambdaQuery().eq(UserPO::getUsername, user.getUsername()).count();
        }while (count>0);
        this.save(user);
        return user;
    }

    @Override
    public boolean removeUser(String uuid) {
        return this.removeById(uuid);
    }

    @Override
    public boolean updateUser(UserPO user) {
        return this.updateById(user);
    }

    @Override
    public UserPO getUser(String uuid) {
        return this.getById(uuid);
    }

    @Override
    public List<UserPO> listUsers(List<String> uuidList) {
        return this.listByIds(uuidList);
    }
}
