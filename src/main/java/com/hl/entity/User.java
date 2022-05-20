package com.hl.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Date:2022/3/24 17:45
 * @Author:NANDI_GUO
 */
@Data
@Builder
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "用户名不能为空;")
    @Pattern(regexp = "^[A-Za-z0-9][\\w-]*$",message = "用户名只能包含英文、数字、下划线、中划线，不能以中划线或下划线开头;")
    @Length(min = 1,max = 64,message = "用户名长度在64位以内;")
    private String username;

    private String sex;

    private Integer age;

    @NotNull(message = "用户真实姓名不能为空;")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9][\\u4E00-\\u9FA5\\w-]*$",message = "用户真实姓名只能包含中文、英文、数字、下划线、中划线，不能以中划线或下划线开头;")
    @Length(min = 1,max = 64,message = "用户真实姓名长度在64位以内;")
    private String realname;

    @NotNull(message = "用户手机号不能为空;")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$",message = "请输入正确的手机号;")
    private String phone;

    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",message = "请输入正确的邮箱;")
    private String email;

    private String password;

    @TableLogic
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    private String createTime;

}
