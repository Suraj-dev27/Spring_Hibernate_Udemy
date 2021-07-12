package com.ssd.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Spring pure java configuration(no xml file)
@EnableAspectJAutoProxy // Spring AOP proxy support
@ComponentScan("com.ssd.aopdemo") // Component scan for components and aspects
public class DemoConfig {

}
