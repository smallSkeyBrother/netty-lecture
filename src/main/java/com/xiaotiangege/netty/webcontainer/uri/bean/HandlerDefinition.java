package com.xiaotiangege.netty.webcontainer.uri.bean;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 请求处理定义
 * @Date 2019/7/23 14:54
 **/
public class HandlerDefinition {

    private String baseUri = "/";

    private String methodUri = "/";

    private Objects controller;

    private Class<?> controllerClass;

    private Method dealMethod;

    private Object[] params;

    public String requestUri() {
        return baseUri.concat(methodUri);
    }

    public Objects getController() {
        return controller;
    }

    public void setController(Objects controller) {
        this.controller = controller;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getMethodUri() {
        return methodUri;
    }

    public void setMethodUri(String methodUri) {
        this.methodUri = methodUri;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getDealMethod() {
        return dealMethod;
    }

    public void setDealMethod(Method dealMethod) {
        this.dealMethod = dealMethod;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
