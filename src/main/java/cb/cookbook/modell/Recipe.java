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

    private String preparationDescription;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.MERGE)
    private List<Ingredient> ingredientsList = new ArrayList<>();

    public void addIngredient(Ingredient ingredient){
        ingredientsList.add(ingredient);
        ingredient.setRecipe(this);
    }

}
// klucz obcy zostanie umieszczony tutaj