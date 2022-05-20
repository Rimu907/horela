package com.hl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hl.dto.UserDto;
import com.hl.entity.User;
import com.hl.enums.ResultEnum;
import com.hl.exceptions.CustomException;
import com.hl.service.IUserService;
import com.hl.utils.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Date:2022/3/24 10:56
 * @Author:NANDI_GUO
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/userspage/{currentPage}/{pageSize}")
    public SysResult getUsersPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        IPage<User> page = new Page<User>(currentPage,pageSize);
        page = userService.page(page);
        return SysResult.success(page);
    }

    @PostMapping("/addUser")
    public SysResult addUser(@RequestBody @Validated UserDto user){
        userService.addUser(user);
        return SysResult.success();
    }

    @PutMapping("/modifyUser")
    public SysResult modifyUser(@RequestBody @Validated UserDto user){
        userService.modifyUser(user);
        return SysResult.success();
    }

    @DeleteMapping("/deleteUser/{id}")
    public SysResult deleteUser(@PathVariable Integer id){
        userService.removeById(id);
        return SysResult.success();
    }
}
