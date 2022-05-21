package com.hl.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.hl.utils.VerifyGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 家庭前端参数(业务实现)
 *
 * @author NANDI_GUO
 * @date 2022/5/21 18:51
 */
public class FamilyDto {

    @NotNull(message = "家庭id不能为空;",groups = {VerifyGroup.Update.class})
    private Integer id;

    @NotNull(message = "家庭名不能为空;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9][\\u4E00-\\u9FA5\\w-]*$",message = "家庭名只能包含中文、英文、数字、下划线、中划线，不能以中划线或下划线开头;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    @Length(min = 1,max = 64,message = "家庭名长度在64位以内;",groups = {VerifyGroup.Create.class,VerifyGroup.Update.class})
    private String familyName;

    private Integer status;
}
