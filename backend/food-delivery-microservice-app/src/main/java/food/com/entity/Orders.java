package food.com.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	//@ElementCollection
    private List<String> cartitems;

    private Double totalPrice;
    private String name;
    private String address;
    
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "payment_id", nullable = true) private Payment payment;
	 */

    private Long paymentId; 
    private LocalDateTime createdAt; 
    private String status;
    public Orders() {
        this.createdAt = LocalDateTime.now(); 
        this.status = "Pending";  // Order starts with Pending status
    }
	

}