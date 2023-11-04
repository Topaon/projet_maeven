package sg.corporation.chopy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.corporation.chopy.entity.Ingredient;

public interface DaoIngredient extends JpaRepository<Ingredient, Long> {

}
