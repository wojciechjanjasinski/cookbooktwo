package cb.cookbook.controller;

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


    @GetMapping("/delete/{id}")
    String deleteForm(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("wprowadzono niepoprawny numer id:" + id));
        model.addAttribute("recipe", recipe);
        return "/delete";
    }

    @PostMapping("delete/{id}")
    String deleteRecipe(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("wprowadzono niepoprawny numer id:" + id));
        recipeRepository.delete(recipe);
        model.addAttribute("recipe", recipe);
        return "redirect:/cookbook/successful-delete";
    }

    @GetMapping("/successful-delete")
    String successfulDelete(){
        return "/successful-delete";
    }

    @GetMapping("/findOne/{id}")
    String showOneRecipe(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("wprowadzono niepoprawny numer id:" + id));
        model.addAttribute("recipe", recipe);
        return "/findOne";
    }

    @GetMapping("/category-polish")
    String showPolishFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findAllPolish();
        model.addAttribute("polish", recipeRepository.findAllPolish());
        return "/category-polish";
    }

    @GetMapping("/category-french")
    String showFrenchFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findAllFrench();
        model.addAttribute("french", recipeRepository.findAllFrench());
        return "/category-french";
    }

    @GetMapping("/category-british")
    String showBritishFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findAllBritish();
        model.addAttribute("british", recipeRepository.findAllBritish());
        return "/category-british";
    }

    @GetMapping("/category-italian")
    String showItalianFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findAllItalian();
        model.addAttribute("italian", recipeRepository.findAllItalian());
        return "/category-italian";
    }

    @GetMapping("/category-mediterranean")
    String showMediterraneanFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findAllMediterranean();
        model.addAttribute("mediterranean", recipeRepository.findAllMediterranean());
        return "/category-mediterranean";
    }

    @GetMapping("/category-american")
    String showAmericanFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findAllAmerican();
        model.addAttribute("american", recipeRepository.findAllAmerican());
        return "/category-american";
    }

    @GetMapping("/category-mexican")
    String showMexicanFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findAllMexican();
        model.addAttribute("mexican", recipeRepository.findAllMexican());
        return "/category-mexican";
    }

    @GetMapping("/category-sweet")
    String showSweetFoodCategory(Model model){
        //String description = "Polskie jedzenie itp."; html
        //picture html
        recipeRepository.findAllSweat();
        model.addAttribute("sweet", recipeRepository.findAllSweat());
        return "/category-sweet";
    }

    @GetMapping("/category")
    String showByCategory() {
        return "/category";
    }
}
