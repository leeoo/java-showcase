运行
-----
先运行根Maven项目即showcase的pom.xml的"mvn install"命令

然后才可以正常地单独运行子模块Maven项目的命令，否则会出现依赖的版本未指定或未找到的错误！

注意：因为子模块之间可能(结合dependencyManagement)使用import方式来非继承式地依赖其他子模块，
    所以需要事先将最顶层执行 mvn install 将其安装到本地仓库！否则子模块执行任何任务都将报找不到版本的错误！



参考
------
* SpringSide
* Appfuse
* Spring-Shiro-training     // https://www.oschina.net/p/spring-shiro-training
Spring Shiro 学习系统
基于 springmvc、spring、mybatis-plus、shiro、easyui、Log4j2 简单实用的权限系统。
Spring-cache、Spring-data-redis、Spring-Task、Shiro、Spring-cache-shiro、maven profile 多环境配置
权限管理、角色管理、用户管理、部门管理、登陆日志、图标管理
* Mybatis-Plus  // http://mp.baomidou.com/#/

* renren-security-boot

