package food.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import food.com.entity.Menu;
@Repository
public interface MenuRepository extends JpaRepository<Menu, String>{

	

	Menu findByMenuId(Long menuId);

	//List<Menu> findByRestaurantId(Long restaurantId);

	List<Menu> findByRestaurantRestaurantId(Long restaurantId);

	List<Menu> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String searchText, String searchText2);

}
