package sg.corporation.chopy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String label;
	
	@ManyToMany
	private List<Ingredient> ingredients;
	
	// Constructors
	public Recipe(long id, String label) {
		super();
		this.id = id;
		this.label = label;
		this.ingredients = new ArrayList<Ingredient>();
	}

	// toString() method
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", label=" + label + ", ingredients=" + ingredients + "]";
	}
}