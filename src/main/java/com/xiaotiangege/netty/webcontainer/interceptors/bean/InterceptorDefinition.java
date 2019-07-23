package com.xiaotiangege.netty.webcontainer.interceptors.bean;

import com.xiaotiangege.netty.webcontainer.interceptors.BizInterceptor;
import org.omg.PortableInterceptor.Interceptor;

import java.util.Objects;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 拦截器定义
 * @Date 2019/7/23 16:05
 **/
public class InterceptorDefinition {

    private String interceptsUri;

    private String excludeUri;

    private BizInterceptor interceptor;

    public String getInterceptsUri() {
        return interceptsUri;
    }

    public void setInterceptsUri(String interceptsUri) {
        this.interceptsUri = interceptsUri;
    }

    public String getExcludeUri() {
        return excludeUri;
    }

    public void setExcludeUri(String excludeUri) {
        this.excludeUri = excludeUri;
    }

    public BizInterceptor getInterceptor() {
        return interceptor;
    }

    public void setInterceptor(BizInterceptor interceptor) {
        this.interceptor = interceptor;
    }
}
