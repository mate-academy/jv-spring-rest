package mate.academy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "mate.academy.spring.controller")
public class WebConfig implements WebMvcConfigurer {
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver internalResourceViewResolver =
                new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setPrefix("/WEB-INF/views");
        return internalResourceViewResolver;
    }
}
