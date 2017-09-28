package com.smart.beanfactory;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author Lex Li
 */
public class BeanFactoryTest {

    @Test
    public void getBean() throws Throwable {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 注：默认情况下，此行会报错！因为放在src/main/java这种source folder下的包内的配置文件的路径
        // 不能在Maven构建时拷贝到对应target/classes目录下，故执行时会报错！若想不报错，就得自定义
        // 问题：maven项目 属性文件默认放在src/main/resources路径下；当将配置文件(.xml，.properties等)放置在java路径下时（mybatis 配置mapping文件等）的问题
//        问题原因：默认配置下，maven在构建过程中java路径下的属性以及配置文件不会被构建（Maven会按照标准的目录结构查找和处理各种类型文件）
//        解决方案：通过相关插件(默认生命周期用到的插件maven-resources-plugin，其他的如maven-antrun-plugin)促使maven对java下的属性及配置文件进行构建

        Resource res = resolver.getResource("classpath:com/smart/beanfactory/beans.xml");
        System.out.println(res.getURL());


    }
}
