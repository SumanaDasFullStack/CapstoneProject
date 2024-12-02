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
	
	
	
	public Object SignIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
			Login existingUser  = result.get();
			if(existingUser .getPassword().equals(login.getPassword())) {
				if (existingUser.getTypeofuser().equals(login.getTypeofuser())) {
                    // Generate a token and return it
                    return existingUser;
                }
				/*if(existingUser .getTypeofuser().equals("admin") && login.getTypeofuser().equals("admin")) {
					return "Admin login successfully";
				}
				else if(existingUser .getTypeofuser().equals("customer") && login.getTypeofuser().equals("customer")) {
					return "Customer login successfully";
				}*/
				else{
					return "Type of user is incorrect";
				}
				
			}
			else {
				return "Password is incorrect";
			}
		}
		else {
			return "Email Id does not exist";
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
