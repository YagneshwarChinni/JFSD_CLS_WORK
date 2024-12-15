package com.klu.jfsd.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.klu.jfsd.springboot.service.CalculatorService;

@SpringBootTest
public class SampleTest 
{
  @Autowired
  private CalculatorService service;
  @Test
  public void testcase1()
  {
    int output = service.add(1, 2);
    assertEquals(3, output);
  }
  @Test
  public void testcase2()
  {
    int output = service.sub(1, 2);
    assertEquals(-1, output);
  }
  @Test
  public void testcase3()
  {
    int output = service.mul(1, 2);
    assertEquals(2, output);
  }
  @Test
  public void testcase4()
  {
    int output = service.div(2, 2);
    assertEquals(1, output);
  }
}