package com.xiaotiangege.netty.webcontainer.interceptors;

import com.xiaotiangege.netty.webcontainer.interceptors.bean.InterceptorDefinition;
import com.xiaotiangege.netty.webcontainer.utils.UriUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 拦截器管理类
 * @Date 2019/7/23 15:07
 **/
public class InterceptManager {

    private List<InterceptorDefinition> intercepts = new CopyOnWriteArrayList<>();

    public InterceptManager() {
    }

    public InterceptManager(List<InterceptorDefinition> intercepts) {
        this.intercepts = intercepts;
    }

    public List<InterceptorDefinition> getIntercepts() {
        return intercepts;
    }

    public void setIntercepts(List<InterceptorDefinition> intercepts) {
        if (this.intercepts.size() == 0) {
            this.intercepts = intercepts;
        } else {
            this.intercepts.addAll(intercepts);
        }
    }

    public boolean registerInterceptor(InterceptorDefinition interceptor) {
        return this.intercepts.add(interceptor);
    }

    public List<BizInterceptor> getHandlerIntercepts(String uri) {
        List<BizInterceptor> list = new ArrayList<>();
        if (intercepts.size() > 0){
            for (InterceptorDefinition definition: intercepts) {
                if (UriUtil.checkUri(uri, definition.getInterceptsUri()) && !UriUtil.checkUri(uri, definition.getExcludeUri())){
                    list.add(definition.getInterceptor());
                }
            }
        }
        return list;
    }
}
