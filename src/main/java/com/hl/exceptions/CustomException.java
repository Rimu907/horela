package com.hl.exceptions;

import com.hl.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常(业务实现)
 *
 * @author NANDI_GUO
 * @date 2022/5/20 15:53
 */
@Data
public class CustomException extends RuntimeException {

    private Integer code;
    private String message;

    public CustomException(ResultEnum resultEnum){
        this.code = resultEnum.getResultCode();
        this.message = resultEnum.getResultMsg();
    }
}
