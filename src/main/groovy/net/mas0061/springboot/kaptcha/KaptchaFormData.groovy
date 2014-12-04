package net.mas0061.springboot.kaptcha

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


public class KaptchaFormData {
	@NotNull
	@Size(min = 5, message = "入力した数字が短すぎます")
	private String kaptcha

  public String getKaptcha() {
    return kaptcha
  }

  public void setKaptcha(String kaptcha) {
    this.kaptcha = kaptcha
  }  
  
}
