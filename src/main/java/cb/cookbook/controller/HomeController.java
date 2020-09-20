package cb.cookbook.controller;

import cb.cookbook.modell.*;
import cb.cookbook.repository.IngredientRepository;
import cb.cookbook.repository.RecipeRepository;
import cb.cookbook.repository.StepRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cookbook")
public class HomeController {

    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;
    private StepRepository stepRepository;

    public HomeController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, StepRepository stepRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.stepRepository = stepRepository;
    }

    @GetMapping
    public String start(){
        return "/index";
    }

    @GetMapping("/all")
    public String findAll (Model model){
        List<Recipe> all = recipeRepository.findAll();
        model.addAttribute("all_recipe", all);
        return "/all";
    }

    @GetMapping("/add")
    public String addRecipe(Model model, Ingredient ingredient, Step step){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        recipe.addIngredientAndStep(ingredient, step);
        //recipe.addStep(step);
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("step", step);
        return "add";
    }

    @PostMapping("/add")
    String addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/cookbook/all";
    }

    @PutMapping("update/{id}")
    String updateRecipe(@PathVariable Long id,
                        @RequestParam(required = false) String dishName,
                        @RequestParam(required = false) FoodCategory foodCategory,
                        @RequestParam(required = false)DifficultyLevel difficultyLevel,
                        @RequestParam(required = false)BigDecimal time,
                        @RequestParam(required = false)List<Ingredient> ingredientsList,
                        @RequestParam(required = false)List<Step> stepsList){
        Recipe recipeToUpdate = recipeRepository.getOne(id);
        recipeToUpdate.setDishName(dishName);
        recipeToUpdate.setFoodCategory(foodCategory);
        recipeToUpdate.setDifficultyLevel(difficultyLevel);
        recipeToUpdate.setTime(time);
        recipeToUpdate.setIngredientsList(ingredientsList);
        recipeToUpdate.setStepsList(stepsList);
        return "{id}";
    }

    @DeleteMapping("delete/{id}")
    String deleteRecipe(@PathVariable Long id){
        recipeRepository.deleteById(id);
        return "redirect:/successful-delate";
    }

    @GetMapping("/findOne")
    Optional<Recipe> showOneRecipe (Long id){
        return recipeRepository.findById(id);
    }

    @GetMapping("/category")
    List<Recipe> showByCategory(FoodCategory foodCategory){
        return recipeRepository.findByFoodCategoryStartingWith(foodCategory);
    }
}
