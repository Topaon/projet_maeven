package sg.corporation.chopy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import sg.corporation.chopy.dao.DaoUser;
import sg.corporation.chopy.entity.User;

@Service
@Slf4j
public class ServiceUser {
	
	@Autowired
	DaoUser daoUser;
	
	public List<User> readAll() {
		log.info("Méthode readAll()");
		return daoUser.findAll();
	}
	
	public User readById(Long id) {
		log.info("Méthode readById()");
		return daoUser.findById(id).orElse(null);
	}
	
	public User saveOrUpdateUser(User user) {
		log.info("Méthode saveOrUpdateUser()");
		return daoUser.save(user);
	}
}