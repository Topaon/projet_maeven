package sg.corporation.chopy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.corporation.chopy.entity.Recipe;

public interface DaoRecipe extends JpaRepository<Recipe, Long> {

}
