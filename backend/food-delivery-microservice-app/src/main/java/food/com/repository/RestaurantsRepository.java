package food.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import food.com.entity.Restaurants;
@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, String>{

	Optional<Restaurants> findByEmailId(String emailId);

}
