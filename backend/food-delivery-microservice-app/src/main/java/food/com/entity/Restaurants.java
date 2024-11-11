package food.com.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Restaurants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long restaurantId;
	private String name;
	private String description;
	@Column(unique = true)
	private String emailId;
	private String phoneNumber;
	private String address;
	private String openTime;
	private String closeTime;
	private Double rating;
	private LocalDateTime createdAt;
	
	

}