package com.xiaotiangege.netty.webcontainer.uri;

import com.xiaotiangege.netty.webcontainer.exception.ContainerException;
import com.xiaotiangege.netty.webcontainer.uri.bean.HandlerDefinition;

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

    /**
     * 解析添加映射
     *
     * @param uri
     * @param definition
     * @return
     */
    public HandlerDefinition addMapping(String uri, HandlerDefinition definition) {
        return uriHandlerMapping.put(uri, definition);
    }

    /**
     * 获取业务处理handle和对应的拦截器
     *
     * @return
     */
    public HandlerDefinition getHandler(String uri) {
        if (uriHandlerMapping.size() <= 0) {
            throw new ContainerException("500");
        }

        if (!uriHandlerMapping.containsKey(uri)) {
            throw new ContainerException("404");
        }

        return uriHandlerMapping.get(uri);
    }
}
