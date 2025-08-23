package com.example.springdemo.demo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RedisController {
    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/demo")
    public String runDemo() {
       redisService.demo();
        return "demo success";
    }
    @GetMapping("/login")
    public String runLogin(String username) {
        String login = redisService.login(username);
        return login;
    }
    @GetMapping("/loginWithSession")
    public String runDemoWithSession() {
        String loginWithSession = redisService.loginWithSession();
        return loginWithSession;


    }

}