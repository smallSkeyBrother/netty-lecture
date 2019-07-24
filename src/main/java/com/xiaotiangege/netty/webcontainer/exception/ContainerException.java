package com.xiaotiangege.netty.webcontainer.exception;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 容器异常
 * @Date 2019/7/23 11:16
 **/
public class ContainerException extends RuntimeException {

    private String errorMsg;

    private Throwable e;

    public ContainerException(String errorMsg) {
        this(null, errorMsg);
    }

    public ContainerException(String message, String errorMsg) {
        this(message, null, errorMsg, null);
    }

    public ContainerException(Throwable cause, Throwable e) {
        this(null, cause, null, e);
    }

    public ContainerException(String message, Throwable cause, String errorMsg, Throwable e) {
        super(message, cause);
        this.errorMsg = errorMsg;
        this.e = e;
    }
}
