package cb.cookbook.modell;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.MERGE)
    List<Ingredient> ingredientsList = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.MERGE)
    List<Step> stepsList = new ArrayList<>();

    public void addIngredientAndStep(Ingredient ingredient, Step step){
        ingredientsList.add(ingredient);
        ingredient.setRecipe(this);
        stepsList.add(step);
        step.setRecipe(this);
    }

    public void addStep(Step step){

    }
}
// klucz obcy zostanie umieszczony tutaj