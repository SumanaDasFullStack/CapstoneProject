package food.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import food.com.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
