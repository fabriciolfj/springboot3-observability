package com.github.fabriciolfj.observability.controller;

import com.github.fabriciolfj.observability.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @GetMapping
    public String sayHello() {
        return service.sayHello();
    }
}
