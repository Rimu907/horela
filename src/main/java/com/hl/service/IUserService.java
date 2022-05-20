package com.hl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hl.dto.UserDto;
import com.hl.entity.User;

/**
 * @Date:2022/3/25 17:36
 * @Author:NANDI_GUO
 */
public interface IUserService extends IService<User> {
    User getUserByName(String userName);
    void addUser(UserDto user);
    void modifyUser(UserDto user);
}
