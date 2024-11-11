package food.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.com.entity.Menu;
import food.com.entity.Restaurants;
import food.com.repository.MenuRepository;
import food.com.repository.RestaurantsRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepository;
	@Autowired
	RestaurantsRepository restaurantsRepository;

	public String addMenu(Menu menuItem) {
		menuRepository.save(menuItem);
		return "Menu item added successfully";
	}

	public List<Menu> getallMenu() {
		return menuRepository.findAll();

	}

	public Menu getMenuDetailsById(Long menu_id) {
		return menuRepository.findByMenuId(menu_id);

	}

	
	
	  public List<Menu> getMenuRestaurantWise(Long restaurantId){ 
		  List<Menu> menu = menuRepository.findByRestaurantRestaurantId(restaurantId);
		
		return menu;
	  
	  }
	  
	// Method to search menus by name or description
	    public List<Menu> searchMenus(String searchText) {
	        return menuRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchText, searchText);
	    }
	 
	  
	 
}