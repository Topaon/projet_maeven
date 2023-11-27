package sg.corporation.chopy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import sg.corporation.chopy.dao.DaoRecipe;
import sg.corporation.chopy.entity.Recipe;

@Service
@Slf4j
public class ServiceRecipe {
	
	@Autowired
	DaoRecipe daoRecipe;
	
	public List<Recipe> readAll() {
		log.info("Méthode readAll()");
		return daoRecipe.findAll();
	}
	
	public Recipe readById(Long id) {
		log.info("Méthode readById()");
		return daoRecipe.findById(id).orElse(null);
	}
}
