package com.videochat.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OnlineVideoChatServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineVideoChatServerApplication.class, args);
    }

}
