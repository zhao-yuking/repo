package com.swpu.tjx.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 同意返回的请求类
 */
//安装lombok依赖就能用下面的注解
@Data        //提供get，set，toString方法
@AllArgsConstructor  //提供全参数构造函数
@NoArgsConstructor  //提供无参构造函数
public class ResponseMessage {
    private Integer status;

    private String msg;

    private Object data;

    public ResponseMessage(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
