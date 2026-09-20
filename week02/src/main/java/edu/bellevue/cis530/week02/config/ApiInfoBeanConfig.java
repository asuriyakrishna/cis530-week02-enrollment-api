package edu.bellevue.cis530.week02.config;

import edu.bellevue.cis530.week02.model.ApiInfoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApiInfoBeanConfig {

    @Bean
    @Scope("prototype")
    public ApiInfoBean apiInfoBean() {
        return new ApiInfoBean();
    }
}
