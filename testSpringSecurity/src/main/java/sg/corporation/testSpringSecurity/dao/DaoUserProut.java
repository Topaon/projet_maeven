package sg.corporation.testSpringSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.corporation.testSpringSecurity.entity.UserProut;

public interface DaoUserProut extends JpaRepository<UserProut, Long>{
	
}
