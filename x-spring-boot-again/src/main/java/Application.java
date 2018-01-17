import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 在Spring Boot v1.2+中，可以在主类上使用 @SpringBootApplication
 * 替代 @Configuration,@ComponentScan,@EnableAutoConfiguration 3个注解。
 * @author Lex Li
 */
// foo_bar
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@EnableTransactionManagement // 启用注解事务管理
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
