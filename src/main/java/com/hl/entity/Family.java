package com.hl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.sql.Date;

/**
 * 家庭实体类(业务实现)
 *
 * @author NANDI_GUO
 * @date 2022/5/21 18:43
 */
public class Family implements Serializable {

    //持久层加 MP 注解
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("family")
    private String familyName;

    @TableLogic
    private Integer status;

    private String createBy;

    private java.util.Date createTime;
}
