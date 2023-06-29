package com.ssyx.acl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//权限管理模块启动类
@SpringBootApplication(scanBasePackages = "com.ssyx")
//@Import(com.ssyx.common.config.Swagger2Config.class)
public class ServiceAclApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class, args);
    }

}
