package com.hl.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.dao.UserMapper;
import com.hl.dto.UserDto;
import com.hl.entity.User;
import com.hl.enums.ResultEnum;
import com.hl.exceptions.CustomException;
import com.hl.service.ILoginService;
import org.springframework.stereotype.Service;

/**
 * 登录实现类(业务实现)
 *
 * @author NANDI_GUO
 * @date 2022/5/21 19:50
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User>  implements ILoginService {
    @Override
    public SaResult loginVerify(UserDto user) {
        LambdaQueryWrapper<User> userWrapper = Wrappers.lambdaQuery();
        userWrapper.eq(User::getUsername,user.getUsername());
        User loginUser = this.getOne(userWrapper);
        if (loginUser == null || !user.getPassword().equals(loginUser.getPassword())) {
            throw new CustomException(ResultEnum.USER_LOGIN_FAILED);
        }
        StpUtil.login(loginUser.getId());
        return SaResult.ok("登陆成功");
    }
}
