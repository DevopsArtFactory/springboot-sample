package com.example.demo.api.sample.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sample")
public class SampleController {
    @Value("${sample.id}")
    String sampleId;

    @Value("${sample.password}")
    String samplePassword;
    
    @Value("${custom.token}")
    String customToken;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHello(){
        return "<h1>Hello</h1>";
    }

    @GetMapping("/terraform")
    @ResponseStatus(HttpStatus.OK)
    public String getTerraform(){
        return "<h1>Hello, Terraform Class</h1>";
    }

    @GetMapping("/eks")
    @ResponseStatus(HttpStatus.OK)
    public String getEks(){
        return "<h1>Hello, Eks Class</h1>";
    }

    @GetMapping("/testSecrets")
    public String getValue() {
        StringBuilder returnMsg = new StringBuilder();
        returnMsg.append("ID :");
        returnMsg.append(sampleId);
        returnMsg.append("Password :");
        returnMsg.append(samplePassword);
        return returnMsg.toString();
    }

    @GetMapping("/testCustomSecrets")
    public String getCustomValue() {
        StringBuilder returnMsg = new StringBuilder();
        // Base64 디코딩
        returnMsg.append("<h1>");
        String decodedToken = new String(Base64.getDecoder().decode(customToken));

        returnMsg.append(decodedToken);
        returnMsg.append("</h1>");
        return returnMsg.toString();
    }
}

