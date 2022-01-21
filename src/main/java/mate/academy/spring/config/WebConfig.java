package mate.academy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "mate.academy.spring.controller")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    public InternalResourceViewResolver resolver() {
        return new InternalResourceViewResolver();
    }

}
