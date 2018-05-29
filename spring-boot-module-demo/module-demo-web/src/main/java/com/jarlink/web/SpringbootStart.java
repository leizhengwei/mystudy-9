package com.jarlink.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * spring boot启动类
 * 
 * @author onlyone
 */

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
                                  DataSourceTransactionManagerAutoConfiguration.class })
public class SpringbootStart {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStart.class, args);
    }

}
