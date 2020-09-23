package cb.cookbook.controller;

import cb.cookbook.dto.IngredientCreationDto;
import cb.cookbook.modell.DifficultyLevel;
import cb.cookbook.modell.FoodCategory;
import cb.cookbook.modell.Ingredient;
import cb.cookbook.modell.Recipe;
import cb.cookbook.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/cookbook")
public class HomeController {

    private RecipeRepository recipeRepository;

    public HomeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    String start() {
        return "/index";
    }

    @GetMapping("/all")
    String findAll(Model model) {
        List<Recipe> all = recipeRepository.findAll();
        model.addAttribute("all_recipe", all);
        return "/all";
    }

    @GetMapping("/add")
    String addRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "/add";
    }

    @PostMapping("/add")
    String addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/cookbook/all";
    }

    @GetMapping("/ingredient-add")
    public String showIngredientAdd(Model model){
        Recipe recipe = new Recipe();
        for (int i = 1; i <= 15; i++){
            recipe.addIngredient(new Ingredient());
        }
        model.addAttribute("ingredientForm", recipe);
        return "/ingredient-add";
    }

    @PostMapping("/ingredient-add")
    public String saveBooks(@ModelAttribute Recipe recipe, Model model) {
        recipeRepository.save(recipe);
        return "redirect:/cookbook/all";
    }

//    @GetMapping("/ingredient-add")
//    public String showCreatForm(Model model) {
//        IngredientCreationDto ingredientCreationDto = new IngredientCreationDto();
//
//        for (int i = 1; i <= 15; i++) {
//            ingredientCreationDto.addIngredient(new Ingredient());
//        }
//        model.addAttribute("ingredientForm", ingredientCreationDto);
//        return "/ingredient-add";
//    }

    @PostMapping("/update/{id}")
    String updateRecipe(@PathVariable Long id,
                        @RequestParam(required = false) String dishName,
                        @RequestParam(required = false) FoodCategory foodCategory,
                        @RequestParam(required = false) DifficultyLevel difficultyLevel,
                        @RequestParam(required = false) BigDecimal time,
                        @RequestParam(required = false) List<Ingredient> ingredientsSet) {
        Recipe recipeToUpdate = recipeRepository.getOne(id);
        recipeToUpdate.setDishName(dishName);
        recipeToUpdate.setFoodCategory(foodCategory);
        recipeToUpdate.setDifficultyLevel(difficultyLevel);
        recipeToUpdate.setTime(time);
        recipeToUpdate.setIngredientsList(ingredientsSet);
        return "{id}";
    }

    @PostMapping("delete/{id}")
    String deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/successful-delate";
    }

    @GetMapping("/findOne")
    Optional<Recipe> showOneRecipe(Long id) {
        return recipeRepository.findById(id);
    }

    @GetMapping("/category")
    List<Recipe> showByCategory(FoodCategory foodCategory) {
        return recipeRepository.findByFoodCategoryStartingWith(foodCategory);
    }
}
