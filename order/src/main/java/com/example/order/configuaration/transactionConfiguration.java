package com.example.order.configuaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class transactionConfiguration {
  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}
