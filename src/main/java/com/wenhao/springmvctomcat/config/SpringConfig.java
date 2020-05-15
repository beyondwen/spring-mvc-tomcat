package com.wenhao.springmvctomcat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.wenhao.springmvctomcat.controller")
@EnableWebMvc
public class SpringConfig {
}
