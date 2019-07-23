package com.xiaotiangege.netty.webcontainer.interceptors;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 请求拦截处理
 * @Date 2019/7/23 10:53
 **/
public interface BizInterceptor {

    /**
     * 业务处理之前调用
     *
     * @return
     */
    boolean beforeHandle();

    /**
     * 业务处理之后执行
     */
    void afterHandle();

    /**
     * 发生异常时调用
     */
    void exceptionHandle();
}
