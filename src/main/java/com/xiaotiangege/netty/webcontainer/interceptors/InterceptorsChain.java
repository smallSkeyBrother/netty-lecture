package com.xiaotiangege.netty.webcontainer.interceptors;

import com.xiaotiangege.netty.webcontainer.uri.bean.HandlerDefinition;

import java.util.List;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 请求拦截器链
 * @Date 2019/7/23 15:14
 **/
public class InterceptorsChain {

    private String requestUri;

    private List<BizInterceptor> interceptors;

    private HandlerDefinition handlerDefinition;

    public InterceptorsChain() {
    }

    public InterceptorsChain(String requestUri, List<BizInterceptor> interceptors, HandlerDefinition handlerDefinition) {
        this.requestUri = requestUri;
        this.interceptors = interceptors;
        this.handlerDefinition = handlerDefinition;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public List<BizInterceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<BizInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    public HandlerDefinition getHandlerDefinition() {
        return handlerDefinition;
    }

    public void setHandlerDefinition(HandlerDefinition handlerDefinition) {
        this.handlerDefinition = handlerDefinition;
    }

    public static InterceptorsChain.InterceptorsChainBuilder builder() {
        return new InterceptorsChain.InterceptorsChainBuilder();
    }

    public static class InterceptorsChainBuilder {
        private String requestUri;
        private List<BizInterceptor> interceptors;
        private HandlerDefinition handlerDefinition;

        public InterceptorsChain.InterceptorsChainBuilder requestUri(String requestUri) {
            this.requestUri = requestUri;
            return this;
        }

        public InterceptorsChain.InterceptorsChainBuilder interceptors(List<BizInterceptor> interceptors) {
            this.interceptors = interceptors;
            return this;
        }

        public InterceptorsChain.InterceptorsChainBuilder handlerDefinition(HandlerDefinition handlerDefinition) {
            this.handlerDefinition = handlerDefinition;
            return this;
        }

        public InterceptorsChain build() {
            return new InterceptorsChain(requestUri, interceptors, handlerDefinition);
        }
    }
}
