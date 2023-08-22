package sg.corporation.chopy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String label;
	
	// Constructors
	public Ingredient(long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}
	
	// toString() method
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", label=" + label + "]";
	}
}