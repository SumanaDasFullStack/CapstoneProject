package food.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.com.entity.Restaurants;
import food.com.repository.RestaurantsRepository;

@Service
public class RestaurantsService {
	
	@Autowired
	RestaurantsRepository restaurantsRepository;
	
	public String addRestaurant(Restaurants restaurant) {
		Optional<Restaurants> res = restaurantsRepository.findByEmailId(restaurant.getEmailId());
		if(res.isPresent()) {
			return "Restaurant is already registered";
		}
		else {
			restaurantsRepository.save(restaurant);
			return "Restaurant registered successfully";
		}
	}
	
	public List<Restaurants> getAllRestaurants(){
		return restaurantsRepository.findAll();
		
	}

}
