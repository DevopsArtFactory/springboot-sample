package com.example.demo.api.sample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sample")
public class SampleController {
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHello(){
        return "<h1>Hello</h1>";
    }

    @GetMapping("/terraform")
    @ResponseStatus(HttpStatus.OK)
    public String getTerraform(){
        return "<h1>Hello, Terraform Master Class</h1>";
    }

}

