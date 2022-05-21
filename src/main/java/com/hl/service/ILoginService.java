package com.hl.service;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hl.dto.UserDto;
import com.hl.entity.User;

/**
 * 登录业务层(接口定义)
 *
 * @author NANDI_GUO
 * @date 2022/5/21 19:47
 */
public interface ILoginService extends IService<User>{
    SaResult loginVerify(UserDto user);
}
