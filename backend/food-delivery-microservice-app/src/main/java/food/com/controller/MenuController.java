package food.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import food.com.entity.Menu;
import food.com.service.MenuService;

@RestController
@RequestMapping("menu")
@CrossOrigin
public class MenuController {
	
	@Autowired
	MenuService menuService;
	//http://localhost:9090/menu/addMenu
	@PostMapping(value = "addMenu", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addMenu(@RequestBody Menu menuItem) {
		return menuService.addMenu(menuItem);
	}
	//http://localhost:9090/menu/allMenu
	@GetMapping(value = "allMenu", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Menu> getAllMenu(){
		return menuService.getallMenu();
	}

	//http://localhost:9090/menu/menuDetails
	@GetMapping(value = "menuDetails/{menuId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Menu getMenuDetails(@PathVariable Long menuId) {
		return menuService.getMenuDetailsById(menuId);
		
	}
	
	//http://localhost:9090/menu/menus/{restaurantId}
		@GetMapping(value = "menus/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<Menu> getMenuRestaurantWise(@PathVariable Long restaurantId) {
			return menuService.getMenuRestaurantWise(restaurantId);
			
		}
		//http://localhost:9090/menu/search?searchText=
				@GetMapping(value = "search", consumes = MediaType.APPLICATION_JSON_VALUE)
				public List<Menu> getSearchMenus(@RequestParam String searchText) {
					return menuService.searchMenus(searchText);
					
				}
}