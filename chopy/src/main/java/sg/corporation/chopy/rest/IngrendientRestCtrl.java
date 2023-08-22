package sg.corporation.chopy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.corporation.chopy.dao.DaoIngredient;
import sg.corporation.chopy.entity.Ingredient;

@RestController
@RequestMapping(value = "/chopy-api", headers="Accept=application/json")
public class IngrendientRestCtrl {
	
	@Autowired
	DaoIngredient daoIngredient;
	
	@GetMapping("")
	public List<Ingredient> getAllIngredients() {
		System.out.println("coucou");
		return daoIngredient.findAll();
	}
	
	@PutMapping("")
	public Ingredient saveIngredient() {
		return daoIngredient.save(new Ingredient(0, "Croissant"));
	}
}