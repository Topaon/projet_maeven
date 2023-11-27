package sg.corporation.chopy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter @Setter @NoArgsConstructor@ToString
@Slf4j
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Product product;
	private float quantity;
	
	public Ingredient(Long id, Product product, float quantity) {
		log.info("Constructeur de la classe Ingredient");
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
}