package sg.corporation.chopy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.corporation.chopy.entity.Recipe;
import sg.corporation.chopy.service.ServiceRecipe;

@RestController
@RequestMapping(value= "/api-chopy/recipe")
public class RecipeRestCtrl {

	@Autowired
	ServiceRecipe serviceRecipe;
	
	@GetMapping("/{id}")
	public Recipe getRecipeById(@PathVariable("id") Long id) {
		Recipe recipe = serviceRecipe.searchById(id);
		return recipe;
	}
	
	@GetMapping("")
	public List<Recipe> getAllRecipe(){
		return serviceRecipe.searchAll();
	}
	
	@PostMapping("")
	public Recipe saveNewRecipe(@RequestBody Recipe recipe) {
		Recipe newRecipe = serviceRecipe.saveOrUpdate(recipe);
		return newRecipe;
	}
	
	@PutMapping("")
	public Recipe updateRecipe(@RequestBody Recipe recipe) {
		if(serviceRecipe.searchById(recipe.getId()) != null) {
			Recipe recipeUpToDate = serviceRecipe.saveOrUpdate(recipe);
			return recipeUpToDate;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecipe(@PathVariable(name="id") Long id) {
		serviceRecipe.removeById(id);
	}
}