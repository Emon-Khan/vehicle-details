package com.shikbeTumio.vehicledetails.api.vehicledetails.config;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.shikbeTumio.vehicledetails.api.vehicledetails.dao")
@PropertySource({"classpath:application.properties"})
@ComponentScan({ "com.shikbeTumio.vehicledetails.api.vehicledetails" })
public class VehicleDetailsJPAConfig {
    ApplicationContext ctx = new GenericApplicationContext();
    private Environment env = ctx.getEnvironment();
    public VehicleDetailsJPAConfig(){
        super();
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("spring.datasource.url")));
        dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("spring.datasource.username")));
        dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("spring.datasource.password")));

        return dataSource;
    }


}
