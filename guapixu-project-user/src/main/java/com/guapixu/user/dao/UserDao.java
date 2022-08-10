package com.guapixu.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guapixu.user.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lizx
 */
@Repository("userDao")
@Mapper
public interface UserDao extends BaseMapper<UserPO> {
}
