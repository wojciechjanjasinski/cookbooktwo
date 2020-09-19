package cb.cookbook.modell;

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

    @OneToMany(mappedBy = "recipe")
    List<Ingredient> ingredientsList;

    @OneToMany(mappedBy = "recipe")
    List<Step> stepsList;
}
// klucz obcy zostanie umieszczony tutaj