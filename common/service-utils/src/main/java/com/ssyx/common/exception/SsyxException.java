package com.ssyx.common.exception;

import com.ssyx.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @description:
 * @author: oywl
 * @time: 2023-6-26 22:24
 */
@Data
public class SsyxException extends RuntimeException{
    //异常状态码
    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param message
     * @param code
     */
    public SsyxException(String message, Integer code) {
        super(message);
        this.code = code;
    }


    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public SsyxException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
