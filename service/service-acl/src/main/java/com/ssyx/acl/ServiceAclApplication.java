package com.ssyx.acl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

//权限管理模块启动类
@SpringBootApplication(scanBasePackages = "com.ssyx")
//@Import(com.ssyx.common.config.Swagger2Config.class)
public class ServiceAclApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class, args);
    }

}
