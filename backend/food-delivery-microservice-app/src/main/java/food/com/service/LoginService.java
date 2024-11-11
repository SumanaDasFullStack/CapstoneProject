package food.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.com.entity.Login;
import food.com.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public String SignIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
			Login ll = result.get();
			if(ll.getPassword().equals(login.getPassword())) {
				if(ll.getTypeofuser().equals("admin") && login.getTypeofuser().equals("admin")) {
					return "Admin login successfully";
				}
				else if(ll.getTypeofuser().equals("customer") && login.getTypeofuser().equals("customer")) {
					return "Customer login successfully";
				}
				else{
					return "Type of user wrong";
				}
				
			}
			else {
				return "Password is wrong";
			}
		}
		else {
			return "Email Id is wrong";
		}
		
		
	}
	
	public String SignUp(Login login) {
		
		if(login.getTypeofuser().equals("admin")) {
			return "You can't create admin login";
		}
		else {
			Optional<Login> result = loginRepository.findById(login.getEmailid());
			if(result.isPresent()) {
				return "Account already exists";
			}
			else{
				loginRepository.save(login);
				return "Account created successfully";
			}
		}
		
		
	}

}
