package com.lex.showcase.serialization.fastson;

import com.alibaba.fastjson.JSON;

/**
 * @author Lex Li
 */
public class FastjsonDemo {

    public static void main(String[] args) {
        InvokeModel invokeModel = new InvokeModel();
        invokeModel.setServiceName("com.lex.showcase.serialization.fastson.SayHello");
        invokeModel.setMethodName("sayHello");
        Object[] getParams = {"张三"};
        Class[] paramsType = {String.class};
        invokeModel.setParams(getParams);
        invokeModel.setParamsType(paramsType);
        String s = JSON.toJSONString(invokeModel);
        System.out.println("invokeModel:"+s);
        InvokeModel s2 = JSON.parseObject(s, InvokeModel.class);
        System.out.println("after change:"+s2.getMethodName());

        String json = JSON.toJSONString(invokeModel);
        System.out.println("序列化: " + json);

        InvokeModel model = JSON.parseObject(json, InvokeModel.class);
        System.out.println("反序列化: " + model);
    }

}

