package sg.corporation.chopy.entity;

import java.util.ArrayList;
import java.util.Comparator;
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
	private Long id;
	private String name;
	private String image_url;
	
	@OneToMany
	private List<Ingredient> ingredients;
	
	// Constructors
	public Recipe(Long id, String label, String image) {
		this.id = id;
		this.name = label;
		this.ingredients = new ArrayList<Ingredient>();
		this.image_url = image;
	}

	// toString() method
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", label=" + name + ", products=" + ingredients + "]";
	}
	
	// Comparators
	public static Comparator<Recipe> ComparatorIngredientsSize = new Comparator<Recipe>() {
		@Override
		public int compare(Recipe recipe1, Recipe recipe2) {
			int index = recipe1.ingredients.size() - recipe2.ingredients.size();
			return index;
		}
	};
	
	public static Comparator<Recipe> ComparatorAlphabetical = new Comparator<Recipe>() {
		@Override
		public int compare(Recipe recipe1, Recipe recipe2) {
			int index = recipe1.ingredients.size() - recipe2.ingredients.size();
			return index;
		}
	};
}