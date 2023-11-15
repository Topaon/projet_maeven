package sg.corporation.chopy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.corporation.chopy.dao.DaoRecipe;
import sg.corporation.chopy.entity.Recipe;

@RestController
@RequestMapping(value = "/chopy-api/recipe", headers="Accept=application/json")
public class RecipeRestCtrl {
	
	@Autowired
	DaoRecipe daoRecipe;
	
	@GetMapping("/{id}")
	public Recipe getRecipeWithId(@PathVariable(name = "id") long id) {
		return daoRecipe.findById(id).orElse(null);
	}
	
	@GetMapping("")
	public List<Recipe> getAllRecipes() {
		return daoRecipe.findAll();
	}
}