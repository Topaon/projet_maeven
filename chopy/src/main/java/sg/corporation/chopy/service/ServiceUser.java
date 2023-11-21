package sg.corporation.chopy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.corporation.chopy.dao.DaoUser;
import sg.corporation.chopy.entity.User;

@Service
public class ServiceUser {
	
	@Autowired
	DaoUser daoUser;
	
	public List<User> readAll() {
		List<User> users = daoUser.findAll();
		return users;
	}
	
	public User readById(Long id) {
		return daoUser.findById(id).orElse(null);
	}
	
	public User saveOrUpdateUser(User user) {
		return daoUser.save(user);
	}
}