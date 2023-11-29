package sg.corporation.chopy.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import sg.corporation.chopy.dao.DaoIngredient;
import sg.corporation.chopy.dao.DaoProduct;
import sg.corporation.chopy.dao.DaoRecipe;
import sg.corporation.chopy.dao.DaoUser;
import sg.corporation.chopy.entity.Ingredient;
import sg.corporation.chopy.entity.Product;
import sg.corporation.chopy.entity.Recipe;
import sg.corporation.chopy.entity.User;

@Component
@Slf4j
public class DataInit {
	
	@Autowired
	DaoProduct daoProduct;
	
	@Autowired
	DaoRecipe daoRecipe;
	
	@Autowired
	DaoIngredient daoIngredient;
	
	@Autowired
	DaoUser daoUser;
	
	@PostConstruct
	public void dataInit() {
		log.info("Initialisation des données");
		//
		Product Pate = daoProduct.save(new Product(0, "Pate", 500, "gramme", "miam"));
		Product Pate2 = daoProduct.save(new Product(0, "Pate", 1000, "gramme", "miam"));
		Product Riz = daoProduct.save(new Product(0, "Riz", 500, "gramme", "miam"));
		Product Riz2 = daoProduct.save(new Product(0, "Riz", 1000, "gramme", "miam"));
		
		Product CremeFraiche = daoProduct.save(new Product(0, "Crème fraîche", 400, "gramme", "miam"));
		Product CremeLiquide = daoProduct.save(new Product(0, "Crème liquide", 125, "ml", "miam"));
		Product Beurre = daoProduct.save(new Product(0, "Beurre", 250, "g", "miam"));
		Product Parmesan = daoProduct.save(new Product(0, "Parmesan", 100, "gramme", "miam"));
		
		Product ViandeHachee = daoProduct.save(new Product(0, "Viande hachée", 100, "gramme", "miam"));
		Product Bacon = daoProduct.save(new Product(0, "Bacon", 100, "gramme", "miam"));
		Product Lardon = daoProduct.save(new Product(0, "Lardon", 150, "gramme", "miam"));
		Product Oeuf = daoProduct.save(new Product(0, "Oeuf", 6, "U", "miam"));
		Product JauneOeuf = daoProduct.save(new Product(0, "Jaune d'oeuf", 6, "U", "miam"));
		Product BlancOeuf = daoProduct.save(new Product(0, "Blanc d'oeuf", 6, "U", "miam"));
		
		Product OignonJaune = daoProduct.save(new Product(0, "Oignon jaune", 1, "U", "miam"));
		Product OignonRouge = daoProduct.save(new Product(0, "Oignon rouge", 1, "U", "miam"));
		Product TomatesConc = daoProduct.save(new Product(0, "Tomates concassées", 500, "gramme", "miam"));
		Product HaricotRouge = daoProduct.save(new Product(0, "Haricots rouges", 500, "gramme", "miam"));
		Product Brocolis = daoProduct.save(new Product(0, "Brocolis", 1, "U", "miam"));
		Product Carotte = daoProduct.save(new Product(0, "Carotte", 1, "U", "miam"));
		
		Product CitronJaune = daoProduct.save(new Product(0, "Citron jaune", 1, "U", "miam"));
		
		Product HuileTournesol = daoProduct.save(new Product(0, "Huile de tournesol", 0, "U", "condiment"));
		Product HuileOlive = daoProduct.save(new Product(0, "Huile d'olive", 0, "U", "condiment"));
		Product HuileSesame = daoProduct.save(new Product(0, "Huile de sésame", 0, "U", "condiment"));
		Product SauceSoja = daoProduct.save(new Product(0, "Sauce soja", 0, "U", "condiment"));
		Product SaucePoisson = daoProduct.save(new Product(0, "Sauce poisson", 0, "U", "condiment"));
		Product Vinaigre = daoProduct.save(new Product(0, "Vinaigre", 0, "U", "condiment"));
		Product Arome = daoProduct.save(new Product(0, "Arome", 0, "U", "condiment"));
		
		Product Origan = daoProduct.save(new Product(0, "Origan", 0, "U", "condiment"));
		Product Coriandre = daoProduct.save(new Product(0, "Coriandre", 0, "U", "condiment"));
		Product Cumin = daoProduct.save(new Product(0, "Cumin", 0, "U", "condiment"));
		Product Piment = daoProduct.save(new Product(0, "Piment", 0, "U", "condiment"));
		
		Product Noisettes = daoProduct.save(new Product(0, "Noisettes", 0, "gramme", "miam"));
		
		//
		Recipe chiliBacon = new Recipe(null, "Chili con carne con bacon", "https://leseng.rosselcdn.net/sites/default/files/dpistyles_v2/ls_16_9_864w/2019/08/07/node_240820/26787467/public/2019/08/07/B9720503088Z.1_20190807152153_000%2BGPTE69ON6.1-0.jpg?itok=QA9jxa5r1565184120");
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, ViandeHachee, 50)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, Bacon, 50)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, Riz, 100)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, TomatesConc, 100)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, HaricotRouge, 60)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, OignonRouge, 0.5f)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, Coriandre, 0)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, HuileTournesol, 0)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, Piment, 0)));
		chiliBacon.getIngredients().add(daoIngredient.save(new Ingredient(0l, Cumin, 0)));
		daoRecipe.save(chiliBacon);
		
		Recipe pateCarbo = new Recipe(null, "Tagliatelles à la carbonara", "https://s3-eu-west-1.amazonaws.com/images-ca-1-0-1-eu/recipe_photos/original/178759/tagliatelles_carbonara.jpg");
		pateCarbo.getIngredients().add(daoIngredient.save(new Ingredient(0l, Pate, 120)));
		pateCarbo.getIngredients().add(daoIngredient.save(new Ingredient(0l, Lardon, 80)));
		pateCarbo.getIngredients().add(daoIngredient.save(new Ingredient(0l, Parmesan, 40)));
		pateCarbo.getIngredients().add(daoIngredient.save(new Ingredient(0l, JauneOeuf, 1)));
		pateCarbo.getIngredients().add(daoIngredient.save(new Ingredient(0l, HuileOlive, 0)));
		daoRecipe.save(pateCarbo);
		
		Recipe pateBrocolis = new Recipe(null, "Pates aux brocolis et crème de parmesan", "https://assets.afcdn.com/recipe/20130823/13610_w1024h1024c1cx1500cy1123.jpg");
		pateBrocolis.getIngredients().add(daoIngredient.save(new Ingredient(0l, Pate, 120)));
		pateBrocolis.getIngredients().add(daoIngredient.save(new Ingredient(0l, Brocolis, 0.5f)));
		pateBrocolis.getIngredients().add(daoIngredient.save(new Ingredient(0l, Parmesan, 25)));
		pateBrocolis.getIngredients().add(daoIngredient.save(new Ingredient(0l, CremeLiquide, 90)));
		pateBrocolis.getIngredients().add(daoIngredient.save(new Ingredient(0l, CitronJaune, 1)));
		pateBrocolis.getIngredients().add(daoIngredient.save(new Ingredient(0l, HuileOlive, 0)));
		daoRecipe.save(pateBrocolis);
		
		Recipe soupeCarotte = new Recipe(null, "Velouté de carottes, coriandre et éclats de noisettes", "https://static.750g.com/images/1200-630/6233b36c031e28991ad1c10bd164bc15/adobestock-169798799.jpeg");
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Carotte, 125)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Coriandre, 0)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Noisettes, 10)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Beurre, 12.5f)));
		daoRecipe.save(soupeCarotte);
		
		Recipe soupeCarott = new Recipe(null, "Velouté de carottes, coriandre et éclats de noisettes", "https://static.750g.com/images/1200-630/6233b36c031e28991ad1c10bd164bc15/adobestock-169798799.jpeg");
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Carotte, 125)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Coriandre, 0)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Noisettes, 10)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Beurre, 12.5f)));
		daoRecipe.save(soupeCarott);
		
		Recipe soupeCarot = new Recipe(null, "Velouté de carottes, coriandre et éclats de noisettes", "https://static.750g.com/images/1200-630/6233b36c031e28991ad1c10bd164bc15/adobestock-169798799.jpeg");
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Carotte, 125)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Coriandre, 0)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Noisettes, 10)));
		soupeCarotte.getIngredients().add(daoIngredient.save(new Ingredient(0l, Beurre, 12.5f)));
		daoRecipe.save(soupeCarot);
		
		daoUser.save(new User("Simon"));
		daoUser.save(new User("Jack"));
		daoUser.save(new User("Matthieu"));
		daoUser.save(new User("Sett"));
	}
}