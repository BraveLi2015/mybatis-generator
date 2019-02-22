package com.baizhi.mybatisgenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @project: BeiJingProject
 * @author: AdminLi
 * @date: 2019/2/22
 */
@SpringBootApplication
@MapperScan("com.baizhi.mybatisgenerator.dao")
public class MGApp {
    public static void main(String[] args) {
        SpringApplication.run(MGApp.class, args);
    }
}
