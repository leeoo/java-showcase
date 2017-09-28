package com.lex.showcase.serialization.fastson;

import java.io.Serializable;

/**
 * @author Lex Li
 */
public class InvokeModel implements Serializable {


    private String methodName;
    private String serviceName;
    private Object[] params;
    private Class[] paramsType;

    public InvokeModel() {
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamsType() {
        return paramsType;
    }

    public void setParamsType(Class[] paramsType) {
        this.paramsType = paramsType;
    }
}
