package cb.cookbook.repository;

import cb.cookbook.modell.FoodCategory;
import cb.cookbook.modell.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByFoodCategoryStartingWith(FoodCategory foodCategory);
}