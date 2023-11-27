package sg.corporation.chopy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sg.corporation.chopy.dao.DaoProduct;
import sg.corporation.chopy.entity.Product;

@RestController
@RequestMapping(value = "/chopy-api/product", headers="Accept=application/json")
@Slf4j
public class ProductRestCtrl {
	
	@Autowired
	DaoProduct daoProduct;
	
	@GetMapping("")
	public List<Product> getAllProducts() {
		log.info("API getAllProducts");
		return daoProduct.findAll();
	}
}