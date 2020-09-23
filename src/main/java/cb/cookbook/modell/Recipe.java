package cb.cookbook.modell;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dishName;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    private BigDecimal time;

    private String preparationDescription;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.MERGE)
    private List<Ingredient> ingredientsList = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredientsList.add(ingredient);
    }

    public Recipe() {
    }

    public Recipe(Long id, String dishName, FoodCategory foodCategory, DifficultyLevel difficultyLevel, BigDecimal time, String preparationDescription, List<Ingredient> ingredientsList) {
        this.id = id;
        this.dishName = dishName;
        this.foodCategory = foodCategory;
        this.difficultyLevel = difficultyLevel;
        this.time = time;
        this.preparationDescription = preparationDescription;
        this.ingredientsList = ingredientsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public String getPreparationDescription() {
        return preparationDescription;
    }

    public void setPreparationDescription(String preparationDescription) {
        this.preparationDescription = preparationDescription;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", foodCategory=" + foodCategory +
                ", difficultyLevel=" + difficultyLevel +
                ", time=" + time +
                ", preparationDescription='" + preparationDescription + '\'' +
                ", ingredientsList=" + ingredientsList +
                '}';
    }
}
// klucz obcy zostanie umieszczony tutaj