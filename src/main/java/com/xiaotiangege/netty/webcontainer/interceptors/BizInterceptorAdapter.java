package com.xiaotiangege.netty.webcontainer.interceptors;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 适配类-用户继承该类可以选择实现部分方法
 * @Date 2019/7/23 10:58
 **/
public class BizInterceptorAdapter implements BizInterceptor {

    @Override
    public boolean beforeHandle() {
        return true;
    }

    @Override
    public void afterHandle() {

    }

    @Override
    public void exceptionHandle() {

    }
}
