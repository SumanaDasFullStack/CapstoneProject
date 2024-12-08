package food.com.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	/*
	 * @ElementCollection private List<String> cartitems;
	 */
	
	 	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "orders_id")  // Join this table with Orders using a foreign key
	    private List<CartItem> cartitems;  // Now holding a List of CartItems

    private Double totalPrice;
    private String name;
    private String address;
    private String emailid;
    
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
