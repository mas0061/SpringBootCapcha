package net.mas0061.springboot.kaptcha

import javax.servlet.http.HttpSession

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import com.google.code.kaptcha.Constants


@Controller
public class KaptchaController {
  
  @Autowired
  SolveKaptchaService solveKaptcha
  
	@ModelAttribute("kaptchaFormData")
	KaptchaFormData setUp() {
		new KaptchaFormData()
	}
	
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String kaptcha() {
    "index"
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String kaptchaAction(@Validated KaptchaFormData kaptchaFormData, BindingResult bindingResult, 
      Model model, HttpSession session) {
	  
	  if (bindingResult.hasErrors()) {
		  return "index"
	  }
	  
	  def expectedKaptcha = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY)
	  
	  if (!solveKaptcha.solve(expectedKaptcha, kaptchaFormData.kaptcha)) {
      model.addAttribute("exception", new Exception("入力した文字が画像と違います。"))
      return "index"
	  }
	  
    "success"
  }
}
