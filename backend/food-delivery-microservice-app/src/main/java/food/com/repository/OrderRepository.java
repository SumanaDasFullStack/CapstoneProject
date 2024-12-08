package food.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import food.com.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long>{

	List<Orders> findByEmailid(String emailid);

}
