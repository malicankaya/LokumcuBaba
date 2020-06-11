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
    //bootstrap dizini için
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.
                addResourceHandler("/webjars/**").
                addResourceLocations("/webjars/");
    }

    //jsp dosyalarının konumu için
    @Bean
    InternalResourceViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //veri tabanı bağlantısı için datasource bilgileri
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

    //formdao'in data source'u alması için
    @Bean
    public FormDAO getFormDAOImplementation()
    {
        return new FormDAOImplementation(getDataSource());
    }
}
