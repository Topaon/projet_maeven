package sg.corporation.chopy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor@ToString
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Integer quantity;
	private String unit;
	private String type;
	
	// Constructors
	public Product(long id, String description, Integer quantity, String unit, String type) {
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.unit = unit;
		this.type = type;
	}
}