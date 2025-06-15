package org.airtribe.LearnerManagementSystemBelC12.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello World!";
  }

  @GetMapping("/")
  public String hello() {
    return "hello from first API";
  }
}
