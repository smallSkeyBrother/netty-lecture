package com.xiaotiangege.netty.webcontainer.interceptors;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 拦截器管理类
 * @Date 2019/7/23 15:07
 **/
public class InterceptManager {

    private List<BizInterceptor> intercepts = new CopyOnWriteArrayList<>();

    public InterceptManager() {
    }

    public InterceptManager(List<BizInterceptor> intercepts) {
        this.intercepts = intercepts;
    }

    public List<BizInterceptor> getIntercepts() {
        return intercepts;
    }

    public void setIntercepts(List<BizInterceptor> intercepts) {
        if (this.intercepts.size() == 0) {
            this.intercepts = intercepts;
        } else {
            this.intercepts.addAll(intercepts);
        }
    }

    public boolean registerInterceptor(BizInterceptor interceptor) {
        return this.intercepts.add(interceptor);
    }

    public List<BizInterceptor> getHandlerIntercepts(String uri) {
        //todo
        return null;
    }
}
