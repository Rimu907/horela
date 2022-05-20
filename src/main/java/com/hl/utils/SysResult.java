package com.hl.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hl.entity.User;
import com.hl.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Date:2022/3/25 18:43
 * @Author:NANDI_GUO
 */
@Data
@AllArgsConstructor
public class SysResult<T> {

    private Integer code;
    private Boolean flag;
    private String msg;
    private T data;

    public static <T> SysResult<T> success(){
        return new SysResult<T>(0,true,"success",null);

    }

    public static <T> SysResult<T> success(T data){
        return new SysResult<T>(0,true,"success",data);
    }

    public static <T> SysResult<T> fail(Integer ResultCode, String ResultMessage){
        return new SysResult<T>(ResultCode,false, ResultMessage, null);
    }
}
