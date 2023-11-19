package sg.corporation.chopy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany
	private List<Ingredient> ingredients;
	
	// Constructors
	public Recipe(long id, String name) {
		this.id = id;
		this.name = name;
		this.ingredients = new ArrayList<Ingredient>();
	}

	// toString() method
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", label=" + name + ", products=" + ingredients + "]";
	}
}