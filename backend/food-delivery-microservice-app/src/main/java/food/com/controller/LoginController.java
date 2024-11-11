package food.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import food.com.entity.Login;
import food.com.service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {
	@Autowired
	LoginService loginService;
	//http://localhost:9090/login/signin
	@PostMapping(value = "signin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String SignIn(@RequestBody Login login) {
		return loginService.SignIn(login);
	}
	//http://localhost:9090/login/signup
	@PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String SignUp(@RequestBody Login login) {
		return loginService.SignUp(login);
	}

}
