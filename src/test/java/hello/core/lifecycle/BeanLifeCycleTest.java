package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

  @Test
  public void lifeCycleTest() {
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(lifeCycleConfig.class);
    NetworkClient client = ac.getBean(NetworkClient.class);
    ac.close();
  }

  @Configuration
  static class lifeCycleConfig {

    //    @Bean(initMethod = "init", destroyMethod = "close")
    //    @Bean(initMethod = "init")
    @Bean
    public NetworkClient networkClient() {
      NetworkClient networkClient = new NetworkClient();
      networkClient.setUrl("https://hello-spring.dev");
      return networkClient;
    }
  }
}
