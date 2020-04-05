package com.bincoding.nonprofit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.bincoding.nonprofit" })
@EnableJpaRepositories(basePackages = { "com.bincoding.nonprofit.repository" })

public class ApplicationConfig {

//    @Bean
//    public UrlBasedViewResolver tilesViewResolver() {
//        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
//        viewResolver.setViewClass(TilesView.class);
//        return viewResolver;
//    }
//
//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        tilesConfigurer.setDefinitions("/WEB-INF/tiles-defs/*.xml");
//        return tilesConfigurer;
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
