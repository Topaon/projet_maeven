package sg.corporation.chopy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.corporation.chopy.entity.User;

public interface DaoUser extends JpaRepository<User, Long> {
	
}