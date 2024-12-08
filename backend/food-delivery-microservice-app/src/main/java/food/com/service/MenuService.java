package food.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.com.entity.Login;
import food.com.entity.Menu;
import food.com.entity.Restaurants;
import food.com.repository.MenuRepository;
import food.com.repository.RestaurantsRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepository;
	@Autowired
	RestaurantsRepository restaurantsRepository;

	public Menu addMenu(Menu menuItem) {
		return menuRepository.save(menuItem);
		//return "Menu item added successfully";
	}
	
	public Menu editMenu(Long menu_id,Menu menuItem) {
		
		/*
		 * if (menuRepository.findByMenuId(menu_id)) {
		 * System.err.println("menu id "+menu_id); menuItem.setMenuId(menu_id);
		 * System.err.println("menu id after set "+menu_id); return
		 * menuRepository.save(menuItem); } System.err.println("no menu id"); return
		 * null; // or throw an exception if the menu doesn't exist
		 */		
		
		Optional<Menu> existingMenu = menuRepository.findByMenuId(menu_id);

	    if (existingMenu.isPresent()) {
	        // Set the menuId explicitly (ensure it remains the same)
	        menuItem.setMenuId(menu_id);
	        return menuRepository.save(menuItem);
	    } else {
	        // Menu not found, return null or throw an exception
	        System.err.println("No menu found with id: " + menu_id);
	        return null; // or throw new EntityNotFoundException("Menu not found");
	    }
	}

	public List<Menu> getallMenu() {
		return menuRepository.findAll();

	}

	public Menu getMenuDetailsById(Long menu_id) {
		Optional<Menu> menu = menuRepository.findByMenuId(menu_id);
        return menu.orElseThrow(() -> new EntityNotFoundException("Menu not found"));

	}

	
	
	  public List<Menu> getMenuRestaurantWise(Long restaurantId){ 
		  List<Menu> menu = menuRepository.findByRestaurantRestaurantId(restaurantId);
		
		return menu;
	  
	  }
	  
	// Method to search menus by name or description
	    public List<Menu> searchMenus(String searchText) {
	        return menuRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchText, searchText);
	    }
	    
	 // Delete menu by id
	    public boolean deleteMenu(Long menuId) {
	        Optional<Menu> menu = menuRepository.findByMenuId(menuId);
	        if (menu.isPresent()) {
	            menuRepository.delete(menu.get());
	            return true;
	        } else {
	            return false; // Menu not found
	        }
	    }
	 
	  
	 
}
