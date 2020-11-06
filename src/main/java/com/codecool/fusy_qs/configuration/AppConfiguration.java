package com.codecool.fusy_qs.configuration;


import com.codecool.fusy_qs.filter.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authorizationFilter() {
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthorizationFilter());
//        registrationBean.addUrlPatterns("/students/achievements");
//        registrationBean.addUrlPatterns("/students/class");
//        registrationBean.addUrlPatterns("/students/experience");
//        registrationBean.addUrlPatterns("/students/experience-update");
//        registrationBean.addUrlPatterns("/students/group");
//        registrationBean.addUrlPatterns("/students/quests");
//        registrationBean.addUrlPatterns("/students/shop-group");
//        registrationBean.addUrlPatterns("/students/shop-individual");
        registrationBean.addUrlPatterns("/students/student");
//        registrationBean.addUrlPatterns("/students/transactions");
        return registrationBean;
    }

}