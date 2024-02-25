package com.example.rage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class MyMetrics {

  private final Counter helloCounter;

  @Autowired
  public MyMetrics(MeterRegistry meterRegistry) {
    this.helloCounter = meterRegistry.counter("myapp.hello.requests");
  }

  public void incrementTest() {
    helloCounter.increment();
  }
}
