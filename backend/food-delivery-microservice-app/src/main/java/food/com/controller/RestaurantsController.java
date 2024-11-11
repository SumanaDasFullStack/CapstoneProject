package food.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import food.com.entity.Restaurants;
import food.com.service.RestaurantsService;

@RestController
@RequestMapping("restaurants")
@CrossOrigin
public class RestaurantsController {
	@Autowired
	RestaurantsService restaurantsService;
	
	//http://localhost:9090/restaurants/addRestaurant
	@PostMapping(value = "addRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addRestaurant(@RequestBody Restaurants restaurant) {
		return restaurantsService.addRestaurant(restaurant);
	}
	//http://localhost:9090/restaurants/allRestaurants
	@GetMapping(value = "allRestaurants", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurants> getAllRestaurants(){
		return restaurantsService.getAllRestaurants();
	}

}
