package com.xiaotiangege.netty.webcontainer.uri;

import com.xiaotiangege.netty.webcontainer.interceptors.BizInterceptor;
import com.xiaotiangege.netty.webcontainer.interceptors.InterceptManager;
import com.xiaotiangege.netty.webcontainer.interceptors.InterceptorsChain;
import com.xiaotiangege.netty.webcontainer.uri.bean.HandlerDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 请求映射（处理器映射器）
 * @Date 2019/7/23 11:19
 **/
public class UriMapping {

    /**
     * 请求处理映射
     */
    private Map<String, HandlerDefinition> uriHandlerMapping = new ConcurrentHashMap<>(64);

    public boolean addMapping() {
        return true;
    }

    /**
     * 获取业务处理handle和对应的拦截器
     *
     * @return
     */
    public InterceptorsChain getHandler(String uri) {
        if (uriHandlerMapping.size() <= 0) {
            throw new RuntimeException("");
        }

        if (!uriHandlerMapping.containsKey(uri)) {
            throw new RuntimeException("404");
        }

        HandlerDefinition handlerDefinition = uriHandlerMapping.get(uri);

        //InterceptManager
        InterceptManager im = new InterceptManager();
        List<BizInterceptor> interceptors = im.getHandlerIntercepts(uri);

        return InterceptorsChain.builder().requestUri(uri).handlerDefinition(handlerDefinition).interceptors(interceptors).build();
    }
}
