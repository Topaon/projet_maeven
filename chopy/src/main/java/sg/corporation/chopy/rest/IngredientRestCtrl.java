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

import sg.corporation.chopy.entity.Ingredient;
import sg.corporation.chopy.service.ServiceIngredient;

@RestController
@RequestMapping(value= "/api-chopy/ingredient")
public class IngredientRestCtrl {

	@Autowired
	ServiceIngredient serviceIngredient;
	
	@GetMapping("/{id}")
	public Ingredient getIngredientById(@PathVariable("id") Long id) {
		Ingredient ingredient = serviceIngredient.searchById(id);
		return ingredient;
	}
	
	@GetMapping("")
	public List<Ingredient> getAllIngredient(){
		return serviceIngredient.searchAll();
	}
	
	@PostMapping("")
	public Ingredient saveNewIngredient(@RequestBody Ingredient ingredient) {
		Ingredient newIngredient = serviceIngredient.saveOrUpdate(ingredient);
		return newIngredient;
	}
	
	@PutMapping("")
	public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
		if(serviceIngredient.searchById(ingredient.getId()) != null) {
			Ingredient ingredientUpToDate = serviceIngredient.saveOrUpdate(ingredient);
			return ingredientUpToDate;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteIngredient(@PathVariable(name="id") Long id) {
		serviceIngredient.removeById(id);
	}
}