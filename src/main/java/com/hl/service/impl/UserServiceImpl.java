package com.hl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.enums.ResultEnum;
import com.hl.dao.UserMapper;
import com.hl.entity.User;
import com.hl.exceptions.CustomException;
import com.hl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date:2022/3/25 17:38
 * @Author:NANDI_GUO
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String userName) {
        LambdaQueryWrapper<User> wq = Wrappers.lambdaQuery();
        wq.eq(User::getUsername,userName);
        return userMapper.selectOne(wq);
    }

    @Override
    public void addUser(User user) {
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
        this.save(user);
    }
}