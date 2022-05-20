package com.hl.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.sql.Date;

/**
 * @Date:2022/3/24 17:45
 * @Author:NANDI_GUO
 */
@Data
@TableName("user")
public class User implements Serializable {
    //持久层加 MP 注解
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String username;

    private String sex;

    private Date birth;

    private String realname;

    private String phone;

    private String email;

    private String password;

    @TableLogic
    private Integer status;

    private String createBy;

    private java.util.Date createTime;

}
