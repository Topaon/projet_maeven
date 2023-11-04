package sg.corporation.chopy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import sg.corporation.chopy.dao.DaoRecipe;
import sg.corporation.chopy.entity.Recipe;

@Service
@Transactional
public class ImplServiceRecipe extends AbstractGenericService<Recipe, Long> implements ServiceRecipe {

	@Autowired
	DaoRecipe daoRecipe;
	
	@Override
	public CrudRepository<Recipe, Long> getDao() {
		return this.daoRecipe;
	}
}