package cb.cookbook.dto;

import cb.cookbook.modell.Ingredient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class IngredientCreationDto {
    private List<Ingredient> ingredients;


    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
