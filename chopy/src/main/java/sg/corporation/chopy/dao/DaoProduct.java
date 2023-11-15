package sg.corporation.chopy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.corporation.chopy.entity.Product;

public interface DaoProduct extends JpaRepository<Product, Long> {
	
}