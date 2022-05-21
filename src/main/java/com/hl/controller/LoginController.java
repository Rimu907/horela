package com.hl.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hl.dto.UserDto;
import com.hl.entity.User;
import com.hl.service.ILoginService;
import com.hl.service.IUserService;
import com.hl.utils.SysResult;
import com.hl.utils.VerifyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器(业务实现)
 *
 * @author NANDI_GUO
 * @date 2022/5/21 19:08
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @RequestMapping("doLogin")
    public SysResult doLogin(@RequestBody @Validated(VerifyGroup.Login.class) UserDto user) {
        SaResult res = loginService.loginVerify(user);
        return SysResult.success(res.getMsg());
    }

    @RequestMapping("doLogout")
    public SysResult doLogout() {
        StpUtil.logout();
        return SysResult.success(SaResult.ok("注销成功").getMsg());
    }

}
