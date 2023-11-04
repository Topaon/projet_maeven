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

import sg.corporation.chopy.entity.Shoplist;
import sg.corporation.chopy.service.ServiceShoplist;

@RestController
@RequestMapping(value= "/api-chopy/shoplist")
public class ShoplistRestCtrl {

	@Autowired
	ServiceShoplist serviceShoplist;
	
	@GetMapping("/{id}")
	public Shoplist getShoplistById(@PathVariable("id") Long id) {
		Shoplist shoplist = serviceShoplist.searchById(id);
		return shoplist;
	}
	
	@GetMapping("")
	public List<Shoplist> getAllShoplist(){
		return serviceShoplist.searchAll();
	}
	
	@PostMapping("")
	public Shoplist saveNewShoplist(@RequestBody Shoplist shoplist) {
		Shoplist newShoplist = serviceShoplist.saveOrUpdate(shoplist);
		return newShoplist;
	}
	
	@PutMapping("")
	public Shoplist updateShoplist(@RequestBody Shoplist shoplist) {
		if(serviceShoplist.searchById(shoplist.getId()) != null) {
			Shoplist shoplistUpToDate = serviceShoplist.saveOrUpdate(shoplist);
			return shoplistUpToDate;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteShoplist(@PathVariable(name="id") Long id) {
		serviceShoplist.removeById(id);
	}
}