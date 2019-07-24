package com.xiaotiangege.netty.webcontainer.uri;

import com.xiaotiangege.netty.webcontainer.interceptors.InterceptorsChain;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 处理链池(享元模式)
 * @Date 2019/7/24 15:51
 **/
public class InterceptorsChainFlyWeightFactory {

    private volatile Map<String, InterceptorsChain> pool = new ConcurrentHashMap<>();

    private UriMappingAdapter adapter;

    private InterceptorsChain addHandleExecutionChain(String uri, InterceptorsChain chain) {
        return pool.put(uri, chain);
    }

    public InterceptorsChain handleExecutionChain(String uri) {
        InterceptorsChain chain = pool.get(uri);
        if (Objects.isNull(chain)) {
            chain = adapter.handleExecutionChain(uri);
            this.addHandleExecutionChain(uri, chain);
        }
        return chain;
    }
}
