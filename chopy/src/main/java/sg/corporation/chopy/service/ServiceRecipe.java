package sg.corporation.chopy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.corporation.chopy.dao.DaoRecipe;
import sg.corporation.chopy.entity.Recipe;

@Service
public class ServiceRecipe {
	
	@Autowired
	DaoRecipe daoRecipe;
	
	public List<Recipe> readAll() {
		List<Recipe> recipes = daoRecipe.findAll();
		
		
		
		return recipes;
	}
	
	public Recipe readById(Long id) {
		return daoRecipe.findById(id).orElse(null);
	}
}
