package com.example.rage.controller;

import com.example.rage.MyMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  private final MyMetrics myMetrics;

  @Autowired
  public MyController(MyMetrics myMetrics) {
    this.myMetrics = myMetrics;
  }

  @GetMapping("/test")
  public String test() {
    myMetrics.incrementTest();
    return "test!";
  }
}