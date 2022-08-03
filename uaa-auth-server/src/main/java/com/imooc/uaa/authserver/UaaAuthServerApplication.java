package com.imooc.uaa.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.imooc.uaa.repository")
@EntityScan("com.imooc.uaa.domain")
@ComponentScan({
    "com.imooc.uaa.security",
    "com.imooc.uaa.repository",
    "com.imooc.uaa.common",
    "com.imooc.uaa.authserver.config",
    "com.imooc.uaa.authserver.oauth2"})
@SpringBootApplication
public class UaaAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaAuthServerApplication.class, args);
    }

}
