package sg.corporation.chopy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.corporation.chopy.entity.User;
import sg.corporation.chopy.service.ServiceUser;

@RestController
@RequestMapping(value = "/chopy-api/user", headers="Accept=application/json")
public class UserRestCtrl {
	
	@Autowired
	ServiceUser serviceUser;
	
	@GetMapping("/{id}")
	public User getUserWithId(@PathVariable(name = "id") long id) {
		return serviceUser.readById(id);
	}
	
	@GetMapping("")
	public List<User> getAllUsers() {
		return serviceUser.readAll();
	}
	
	@PostMapping("")
	public User registerUser(User user) {
		return serviceUser.saveOrUpdateUser(user);
	}
}