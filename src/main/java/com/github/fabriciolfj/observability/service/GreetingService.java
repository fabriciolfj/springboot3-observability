package com.github.fabriciolfj.observability.service;


import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Observed(name = "greetingService")
@RequiredArgsConstructor
public class GreetingService {


    @GetMapping
    public String sayHello() {
        return "Hello world!";
    }
}
