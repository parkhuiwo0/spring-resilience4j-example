package com.example.springresilienc4j.web;

import com.example.springresilienc4j.application.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/circuit-breaker")
@RequiredArgsConstructor
class MyRestController {

    private final MyService myService;

    @GetMapping
    public String hello(@RequestParam("id") long id) {
        return myService.doService(id);
    }
}
