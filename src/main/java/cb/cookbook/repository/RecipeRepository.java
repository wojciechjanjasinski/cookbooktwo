package cb.cookbook.repository;

import cb.cookbook.modell.FoodCategory;
import cb.cookbook.modell.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByFoodCategory(FoodCategory foodCategory);

    default List<Recipe> findAllPolish() {
        return findByFoodCategory(FoodCategory.POLSKA);
    }

    default List<Recipe> findAllFrench() {
        return findByFoodCategory(FoodCategory.FRANCUSKA);
    }

    default List<Recipe> findAllBritish() {
        return findByFoodCategory(FoodCategory.BRYTYJSKA);
    }

    default List<Recipe> findAllItalian() {
        return findByFoodCategory(FoodCategory.WLOSKA);
    }

    default List<Recipe> findAllMediterranean() {
        return findByFoodCategory(FoodCategory.SRODZIEMNOMORSKA);
    }

    default List<Recipe> findAllAmerican() {
        return findByFoodCategory(FoodCategory.AMERYKANSKA);
    }

    default List<Recipe> findAllMexican() {
        return findByFoodCategory(FoodCategory.MEKSYKANSKA);
    }

    default List<Recipe> findAllSweat() {
        return findByFoodCategory(FoodCategory.SLODKIE);
    }

}