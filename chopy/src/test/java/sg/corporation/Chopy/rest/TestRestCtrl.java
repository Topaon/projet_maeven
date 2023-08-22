package sg.corporation.Chopy.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.corporation.chopy.dao.DaoIngredient;
import sg.corporation.chopy.dao.DaoRecipe;
import sg.corporation.chopy.entity.Ingredient;
import sg.corporation.chopy.entity.Recipe;

@SpringBootTest
public class TestRestCtrl {

	@Autowired
	DaoIngredient daoIngredient;
	
	@Autowired
	DaoRecipe daoRecipe;
	
	@Test
	public void testManyToMany() {
		Ingredient ing1 = daoIngredient.save(new Ingredient(0, "Eau"));
		Ingredient ing2 = daoIngredient.save(new Ingredient(0, "Farine"));
		Ingredient ing3 = daoIngredient.save(new Ingredient(0, "Sel"));
		
		Recipe rec1 = new Recipe(0, "Nouilles");
		
		rec1.getIngredients().add(ing1);
		rec1.getIngredients().add(ing2);
		rec1.getIngredients().add(ing3);
		
		daoRecipe.save(rec1);
	}
}
