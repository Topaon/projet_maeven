package sg.corporation.chopy.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sg.corporation.chopy.entity.Recipe;
import sg.corporation.chopy.service.ServiceRecipe;

@Component
public class DataInit {

	@Autowired
	ServiceRecipe serviceRecipe;
	
	@PostConstruct
	public void initializeData() {
		serviceRecipe.saveOrUpdate(new Recipe("Pâtes aux saucisses"));
		serviceRecipe.saveOrUpdate(new Recipe("Tantanmen"));
		serviceRecipe.saveOrUpdate(new Recipe("Pad Thaï"));
		serviceRecipe.saveOrUpdate(new Recipe("Lentilles saucisse"));
		serviceRecipe.saveOrUpdate(new Recipe("Haricots rouges"));
		serviceRecipe.saveOrUpdate(new Recipe("Petits pois carottes"));
		serviceRecipe.saveOrUpdate(new Recipe("Ratatouille Porc Gingembre"));
		serviceRecipe.saveOrUpdate(new Recipe("Melon au jambon de pays"));
		serviceRecipe.saveOrUpdate(new Recipe("Avoine"));
		serviceRecipe.saveOrUpdate(new Recipe("Banane"));
		serviceRecipe.saveOrUpdate(new Recipe("Céréales"));
		serviceRecipe.saveOrUpdate(new Recipe("Pain"));
		serviceRecipe.saveOrUpdate(new Recipe("Gateaux"));
		serviceRecipe.saveOrUpdate(new Recipe("Resto"));
	}
}