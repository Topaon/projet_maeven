package sg.corporation.chopy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import sg.corporation.chopy.dao.DaoIngredient;
import sg.corporation.chopy.entity.Ingredient;

@Service
@Transactional
public class ImplServiceIngredient extends AbstractGenericService<Ingredient, Long> implements ServiceIngredient {

	@Autowired
	DaoIngredient daoIngredient;
	
	@Override
	public CrudRepository<Ingredient, Long> getDao() {
		return this.daoIngredient;
	}

}
