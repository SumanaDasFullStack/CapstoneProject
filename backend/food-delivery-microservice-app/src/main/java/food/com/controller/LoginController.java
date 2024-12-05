package food.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import food.com.entity.Login;
import food.com.service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

	@Autowired
    LoginService loginService;


 

	// http://localhost:9090/login/signin
	
	  @PostMapping(value = "signin", consumes = MediaType.APPLICATION_JSON_VALUE)
	  public Object SignIn(@RequestBody Login login) {
	
	  return loginService.SignIn(login); 
	  }
	 
	

	// http://localhost:9090/login/signup
	@PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String SignUp(@RequestBody Login login) {
		return loginService.SignUp(login);
	}
	//http://localhost:9090/login/users/allUser?searchText=
	@GetMapping(value = "users/allUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Login> findallUsers(@RequestParam String searchText){
		return loginService.getAllUsers(searchText);
		}
	//http://localhost:9090/login/users/update?emailid=
	@PutMapping(value = "users/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Login updateUser(@RequestParam String emailid, @RequestBody Login user) {
		return loginService.updateUser(emailid, user);
	}
	

}
