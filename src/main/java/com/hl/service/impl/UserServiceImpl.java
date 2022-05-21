package com.hl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.dto.UserDto;
import com.hl.enums.ResultEnum;
import com.hl.dao.UserMapper;
import com.hl.entity.User;
import com.hl.exceptions.CustomException;
import com.hl.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * @Date:2022/3/25 17:38
 * @Author:NANDI_GUO
 */

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void modifyUser(UserDto user) {
        LambdaQueryWrapper<User> userWrapper = Wrappers.lambdaQuery();
        userWrapper.ne(User::getId,user.getId())
                   .and(w -> w.eq(User::getUsername,user.getUsername()).or()
                        .eq(User::getRealname,user.getRealname()).or()
                        .eq(User::getPhone,user.getPhone()));

        User userQuery = this.getOne(userWrapper);
        if(userQuery != null){
            if(userQuery.getUsername().equals(user.getUsername())){
                throw new CustomException(ResultEnum.USER_NAME_EXISTS);
            }
            if(userQuery.getRealname().equals(user.getRealname())){
                throw new CustomException(ResultEnum.USER_REALNAME_EXISTS);
            }
            if(userQuery.getPhone().equals(user.getPhone())){
                throw new CustomException(ResultEnum.USER_PHONE_EXISTS);
            }
        }

        User updateUser = BeanUtil.copyProperties(user, User.class);
        updateById(updateUser);
        log.info("用户更新成功: " + user);
    }

    @Override
    public void addUser(UserDto user) {
        LambdaQueryWrapper<User> userWrapper = Wrappers.lambdaQuery();
        userWrapper.eq(User::getUsername,user.getUsername()).or()
                .eq(User::getRealname,user.getRealname()).or()
                .eq(User::getPhone,user.getPhone());
        User userQuery = this.getOne(userWrapper);
        if(userQuery != null){
            if(userQuery.getUsername().equals(user.getUsername())){
                throw new CustomException(ResultEnum.USER_NAME_EXISTS);
            }
            if(userQuery.getRealname().equals(user.getRealname())){
                throw new CustomException(ResultEnum.USER_REALNAME_EXISTS);
            }
            if(userQuery.getPhone().equals(user.getPhone())){
                throw new CustomException(ResultEnum.USER_PHONE_EXISTS);
            }
        }

        User addUser = BeanUtil.copyProperties(user, User.class);
        this.save(addUser);

        log.info("用户新增成功: " + user);
    }
}
