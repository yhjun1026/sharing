package cn.sharing.platform.common;

import lombok.Data;


/**
 * Created by MSI on 2018/1/4.
 */
@Data
public class ResponseResult<T> {
    private int status;
    private String message;
    private T data;
}
