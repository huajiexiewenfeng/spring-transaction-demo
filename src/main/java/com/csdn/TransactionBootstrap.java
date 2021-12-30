package com.csdn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 示例启动引导类
 *
 * @author ：xwf
 * @date ：Created in 2021-12-27 16:52
 */
@MapperScan("com.csdn.dao")
@SpringBootApplication
@EnableTransactionManagement
public class TransactionBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(TransactionBootstrap.class, args);
    }
}
