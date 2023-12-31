package sg.corporation.chopy.rest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sg.corporation.chopy.entity.Recipe;
import sg.corporation.chopy.service.ServiceRecipe;

@RestController
@RequestMapping(value = "/chopy-api/recipe", headers="Accept=application/json")
@Slf4j
@CrossOrigin(origins = "*")
public class RecipeRestCtrl {
	
	@Autowired
	ServiceRecipe serviceRecipe;
	
	@GetMapping("/{id}")
	public Recipe getRecipeWithId(@PathVariable(name = "id") long id) {
		log.info("API getRecipeWithId");
		return serviceRecipe.readById(id);
	}
	
	@GetMapping("")
	public List<Recipe> getAllRecipes() {
		log.info("API getAllRecipes");
		List<Recipe> sortedList = serviceRecipe.readAll();
		Collections.sort(sortedList, Comparator.comparing(s -> s.getIngredients().size()));
		return sortedList;
	}
}