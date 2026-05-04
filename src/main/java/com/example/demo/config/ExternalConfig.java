package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.example.external")
@Configuration
public class ExternalConfig {

}
