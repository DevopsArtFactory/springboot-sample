package com.example.demo.api.sample.controller;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
    @Value("${sample.id}")
    String sampleId;

    @Value("${sample.password}")
    String samplePassword;
    
    @Value("${custom.token}")
    String customToken;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHello(){
        logger.info("Call Get Method: Hello");
        return "<h1>Hello</h1>";
    }

    @GetMapping("/terraform")
    @ResponseStatus(HttpStatus.OK)
    public String getTerraform(){
        logger.info("Call Get Method: Terraform");

        return "<h1>Hello, Terraform Class</h1>";
    }

    @GetMapping("/eks")
    @ResponseStatus(HttpStatus.OK)
    public String getEks(){
        logger.info("Call Get Method: EKS");

        return "<h1>Hello, Eks Class</h1>";
    }

    @GetMapping("/testSecrets")
    public String getValue() {
        logger.info("Call Get Method: testSecrets");

        StringBuilder returnMsg = new StringBuilder();

        returnMsg.append("ID :");
        returnMsg.append(sampleId);
        returnMsg.append("Password :");
        returnMsg.append(samplePassword);
        logger.info("Success Build returnMsg");

        return returnMsg.toString();
    }

    @GetMapping("/testCustomSecrets")
    public String getCustomValue() {
        logger.info("Call Get Method: testCustomSecrets");

        StringBuilder returnMsg = new StringBuilder();
        // Base64 디코딩
        returnMsg.append("<h1>");
        String decodedToken = new String(Base64.getDecoder().decode(customToken));
        logger.info("Success Decode token");

        returnMsg.append(decodedToken);
        returnMsg.append("</h1>");
        logger.info("Success Build returnMsg");

        return returnMsg.toString();
    }
}

