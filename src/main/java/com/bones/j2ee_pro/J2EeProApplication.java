package com.bones.j2ee_pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bones.j2ee_pro.mapper")
public class J2EeProApplication {

    public static void main(String[] args) {
        SpringApplication.run(J2EeProApplication.class, args);
    }

}
