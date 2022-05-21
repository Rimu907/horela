package com.hl.dto;

import com.hl.service.IUserService;
import com.hl.utils.VerifyGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;


/**
 * 用户数据接收(业务实现)
 *
 * @author NANDI_GUO
 * @date 2022/5/20 22:50
 */
@Data
public class UserDto {
    //Dto加校验注解
    @NotNull(message = "用户名不能为空;",groups = {VerifyGroup.Update.class})
    private Integer id;

    @NotNull(message = "用户名不能为空;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    @Pattern(regexp = "^[A-Za-z0-9][\\w-]*$",message = "用户名只能包含英文、数字、下划线、中划线，不能以中划线或下划线开头;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    @Length(min = 1,max = 64,message = "用户名长度在64位以内;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    private String username;

    private String sex;

    private Date birth;

    @NotNull(message = "用户真实姓名不能为空;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9][\\u4E00-\\u9FA5\\w-]*$",message = "用户真实姓名只能包含中文、英文、数字、下划线、中划线，不能以中划线或下划线开头;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    @Length(min = 1,max = 64,message = "用户真实姓名长度在64位以内;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    private String realname;

    @NotNull(message = "用户手机号不能为空;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$",message = "手机号格式不正确, 请检查后重试;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    private String phone;

    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",message = "邮箱格式不正确, 请检查后重试;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    private String email;

    @NotNull(message = "密码不能为空",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,10}$", message = "密码必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 8-10 之间;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    private String password;

    private Integer status;
}
