package cb.cookbook.controller;

import cb.cookbook.modell.FoodCategory;
import cb.cookbook.modell.Ingredient;
import cb.cookbook.modell.Recipe;
import cb.cookbook.repository.RecipeRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        for (int i = 1; i <= 8; i++) {
            recipe.addIngredient(new Ingredient());
        }
        model.addAttribute("recipe", recipe);
        return "/add";
    }

    @PostMapping("/add")
    String addRecipe(Recipe recipe) {
        recipe.getIngredientsList().stream().forEach(ingredient -> ingredient.setRecipe(recipe));
        recipeRepository.save(recipe);
        return "redirect:/cookbook/all";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("recipe", recipe);
        return "update";
    }

    @PostMapping("/update/{id}")
    String updateRecipe(@PathVariable Long id,
                        Recipe recipeRequest) {
        recipeRepository.findById(id)
                .map(recipe -> {
                    recipe.setDishName(recipeRequest.getDishName());
                    recipe.setFoodCategory(recipeRequest.getFoodCategory());
                    recipe.setDifficultyLevel(recipeRequest.getDifficultyLevel());
                    recipe.setTime(recipeRequest.getTime());
                    recipe.setPreparationDescription(recipeRequest.getPreparationDescription());
                    recipe.setIngredientsList(recipeRequest.getIngredientsList());
                    recipe.getIngredientsList().stream().forEach(ingredient -> ingredient.setRecipe(recipe));
                    return recipeRepository.save(recipe);
                }).orElseThrow(()-> new ResourceNotFoundException("Przepis o numerze" + id + "nie został znaleziony"));
        return "redirect:/cookbook/all";
    }

    @GetMapping("/successful-delete")
    String successfulDelete(){
        return "/successful-delete";
    }

    @PostMapping("delete/{id}")
    String deleteRecipe(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("wprowadzono niepoprawny numer id:" + id));
        recipeRepository.delete(recipe);
        model.addAttribute("recipe", recipe);
        return "redirect:/cookbook/successful-delete";
    }



    @GetMapping("/findOne/{id}")
    Recipe showOneRecipe(@PathVariable Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("wprowadzono niepoprawny numer id:" + id));
    }

    @GetMapping("/category/polish")
    String showPolishFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findByFoodCategoryStartingWith(FoodCategory.POLSKA);
        model.addAttribute("polish", recipeRepository.findByFoodCategoryStartingWith(FoodCategory.POLSKA));
        return "/category/polish";
    }

    @GetMapping("/category/french")
    String showFrenchFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findByFoodCategoryStartingWith(FoodCategory.FRANCUSKA);
        model.addAttribute("french", recipeRepository.findByFoodCategoryStartingWith(FoodCategory.FRANCUSKA));
        return "/category/french";
    }

    @GetMapping("/category/british")
    String showBritishFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findByFoodCategoryStartingWith(FoodCategory.BRYTYJSKA);
        model.addAttribute("british", recipeRepository.findByFoodCategoryStartingWith(FoodCategory.BRYTYJSKA));
        return "/category/british";
    }

    @GetMapping("/category/italian")
    String showItalianFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findByFoodCategoryStartingWith(FoodCategory.WLOSKA);
        model.addAttribute("italian", recipeRepository.findByFoodCategoryStartingWith(FoodCategory.WLOSKA));
        return "/category/italian";
    }

    @GetMapping("/category/mediterranean")
    String showMediterraneanFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findByFoodCategoryStartingWith(FoodCategory.SRODZIEMNOMORSKA);
        model.addAttribute("mediterranean", recipeRepository.findByFoodCategoryStartingWith(FoodCategory.SRODZIEMNOMORSKA));
        return "/category/mediterranean";
    }

    @GetMapping("/category/american")
    String showAmericanFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findByFoodCategoryStartingWith(FoodCategory.AMERYKANSKA);
        model.addAttribute("american", recipeRepository.findByFoodCategoryStartingWith(FoodCategory.AMERYKANSKA));
        return "/category/american";
    }

    @GetMapping("/category/mexican")
    String showMexicanFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findByFoodCategoryStartingWith(FoodCategory.MEKSYKANSKA);
        model.addAttribute("mexican", recipeRepository.findByFoodCategoryStartingWith(FoodCategory.MEKSYKANSKA));
        return "/category/mexican";
    }

    @GetMapping("/category/sweet")
    String showSweetFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findByFoodCategoryStartingWith(FoodCategory.SLODKIE);
        model.addAttribute("sweet", recipeRepository.findByFoodCategoryStartingWith(FoodCategory.SLODKIE));
        return "/category/sweet";
    }

    @GetMapping("/category")
    String showByCategory(Model model,
                        @RequestParam(required = false) FoodCategory foodCategory) {
        switch (foodCategory){
            case POLSKA -> showPolishFoodCategory(model);
            case FRANCUSKA -> showFrenchFoodCategory(model);
            case BRYTYJSKA -> showBritishFoodCategory(model);
            case WLOSKA -> showItalianFoodCategory(model);
            case SRODZIEMNOMORSKA -> showMediterraneanFoodCategory(model);
            case AMERYKANSKA -> showAmericanFoodCategory(model);
            case MEKSYKANSKA -> showMexicanFoodCategory(model);
            case SLODKIE -> showSweetFoodCategory(model);
            default -> throw new IllegalStateException("Unexpected value: " + foodCategory);
        }
        model.addAttribute("category", foodCategory);
        return "/category";
    }
}
