package food.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import food.com.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

	

	List<Login> findByNameContainingIgnoreCaseOrEmailidContainingIgnoreCase(String searchText, String searchText2);

	Login findByEmailid(String emailid);

}
