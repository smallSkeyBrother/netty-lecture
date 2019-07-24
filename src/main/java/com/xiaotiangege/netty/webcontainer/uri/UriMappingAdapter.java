package com.xiaotiangege.netty.webcontainer.uri;

import com.xiaotiangege.netty.webcontainer.interceptors.BizInterceptor;
import com.xiaotiangege.netty.webcontainer.interceptors.InterceptManager;
import com.xiaotiangege.netty.webcontainer.interceptors.InterceptorsChain;
import com.xiaotiangege.netty.webcontainer.uri.bean.HandlerDefinition;

import java.util.List;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 映射器适配器
 * @Date 2019/7/24 15:25
 **/
public class UriMappingAdapter extends UriMapping {

    /**
     * 拦截器控制器
     */
    private InterceptManager interceptManager;

    /**
     * 获取业务执行器和拦截器链
     * @param uri
     * @return
     */
    public InterceptorsChain handleExecutionChain(String uri){
        //获取处理器
        HandlerDefinition handlerDefinition = this.getHandler(uri);
        //获取对应的拦截器
        List<BizInterceptor> interceptors = interceptManager.getHandlerIntercepts(uri);
        //返回结果
        return InterceptorsChain.builder().requestUri(uri).handlerDefinition(handlerDefinition).interceptors(interceptors).build();
    }
}
