package org.malicankaya.services;

import org.malicankaya.dao.FormDAO;
import org.malicankaya.dao.FormDAOImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.time.format.DateTimeFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "org.malicankaya.controller")
public class LokumConfig implements WebMvcConfigurer
{
    //for bootstrap
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.
                addResourceHandler("/webjars/**").
                addResourceLocations("/webjars/");
    }

    @Bean
    InternalResourceViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lokumcubaba");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        return dataSource;
    }

    @Bean
    public FormDAO getFormDAOImplementation()
    {
        return new FormDAOImplementation(getDataSource());
    }
}
