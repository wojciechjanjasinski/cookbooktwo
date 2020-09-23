package cb.cookbook.dto;

import cb.cookbook.modell.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientCreationDto {
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public IngredientCreationDto() {
    }

    public IngredientCreationDto(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

}
