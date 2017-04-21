
* 查看项目的Maven依赖树  
mvn dependency:tree

* 使用MyBaits-Generator插件生成代码  
mvn mybatis-generator:generate

* 执行Maven构建时报子模块不存在的问题  
Q：怎么在Maven项目根模块目录下执行 mvn clean 时报“Child module /Users/libo/workshop/java-showcase/x-learning of /Users/libo/workshop/java-showcase/pom.xml does not exist”
A：找到对应的子模块，将其目录名改为“x-learning”。（改之前的名字是learning）
