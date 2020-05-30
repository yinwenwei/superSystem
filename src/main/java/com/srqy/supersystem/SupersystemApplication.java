package com.srqy.supersystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan({"com.baomidou.mybatisplus.samples.quickstart.mapper","com.srqy.supersystem.manager.*.mapper"})
public class SupersystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupersystemApplication.class, args);
    }

}
