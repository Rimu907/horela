package com.hl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hl.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Date:2022/3/24 17:58
 * @Author:NANDI_GUO
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {}
