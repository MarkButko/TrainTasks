import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

 @Bean(initMethod = "init", destroyMethod = "destroyMethod")
    public MyAwareBean avare() {
     return new MyAwareBean();
 }

 @Bean
    public PostProcessor initializator() {
     return new PostProcessor();
 }
}
