package com.example.springdemo.demos.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description
 * @Author miaoyongbin
 * @Date 2025/6/16 21:43:01
 * @Version 1.0
 */
@SpringBootApplication
@RestController
@CrossOrigin // 允许跨域
public class DanmuWallApplication {
    private final List<Danmu> danmus = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public static void main(String[] args) {
        SpringApplication.run(DanmuWallApplication.class, args);
    }

    // 获取所有弹幕
    @GetMapping("/api/danmus")
    public List<Danmu> getDanmus() {
        return danmus;
    }

    // 发送弹幕
    @PostMapping("/api/danmus")
    public ResponseEntity<Danmu> addDanmu(@RequestBody Danmu danmu) {
        danmu.setId(idGen.getAndIncrement());
        danmu.setTime(LocalDateTime.now().toString());
        danmus.add(danmu);
        return new ResponseEntity<>(danmu, HttpStatus.CREATED);
    }

    // 弹幕实体
    public static class Danmu {
        private Long id;
        private String content;
        private String time;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
        public String getTime() { return time; }
        public void setTime(String time) { this.time = time; }
    }
}
