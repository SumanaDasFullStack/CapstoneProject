package food.com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuId;
	private String name;
	private String category;
	@Column(columnDefinition = "longblob")
	private String image;
	@Column(columnDefinition = "text")
	private String description;
	private Double price;
	private Boolean isAvailable = true;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurant;

}
