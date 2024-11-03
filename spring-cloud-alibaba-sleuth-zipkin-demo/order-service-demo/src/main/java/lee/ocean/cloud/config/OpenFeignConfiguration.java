package lee.ocean.cloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfiguration {

    @Bean
    public Logger.Level openFeignLogLevel() {
        return Logger.Level.FULL;
    }

}
