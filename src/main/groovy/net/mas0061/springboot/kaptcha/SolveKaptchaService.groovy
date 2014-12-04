package net.mas0061.springboot.kaptcha

import org.springframework.stereotype.Service

@Service
public class SolveKaptchaService {

  public boolean solve(String expected, String actual) {
    actual.equalsIgnoreCase(expected)
  }
}
