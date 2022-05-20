package com.hl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 异常信息 枚举类型定义
 *
 * @author NANDI_GUO
 * @date 2022/5/20 15:39
 */
@ToString
@AllArgsConstructor
public enum ResultEnum {
    SYSTEM_ERROR(500,"系统异常"),
    // 数据操作错误定义
    //用户
    PARAM_NULL(100, "参数不能为空"),
    USER_ADD_NULL(101, "新增用户参数不能为空"),
    USER_UPDATE_NULL(102, "更新用户参数不能为空"),
    USER_EXISTS(102, "该账号已存在，请检查后重试"),
    USER_NOT_EXISTS(103, "该用户不存在，请先在租户下创建此用户"),
    LOCAL_USER_NOT_EXISTS(104, "该用户不存在, 请先在租户下创建此用户"),
    USER_NAME_EXISTS(105,"用户账号已存在，请检查后重试"),
    USER_PHONE_EXISTS(106,"用户手机号已存在，请检查后重试"),
    USER_REALNAME_EXISTS(107,"用户真实姓名已存在，请检查后重试"),
    USER_STATUS_LIMIT(108,"该用户正被禁用"),
    USER_INSERT_ERROR(109,"用户新增失败"),
    USER_MODIFY_ERROR(110,"用户更新失败")

    ;

    /** 错误码 */
    @Getter
    private final Integer resultCode;

    /** 错误描述 */
    @Getter
    private final String resultMsg;

}
