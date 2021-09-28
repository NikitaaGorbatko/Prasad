package nikitagorbatko.example.prasad.database

import androidx.room.*


@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey val recipeId: Int,
    val nameRu: String,
    val nameEn: String,
    val technologyRu: String,
    val technologyEn: String
)

@Entity(tableName = "ingredient")
data class Ingredient(
    @PrimaryKey val ingredientId: Int,
    val nameRu: String,
    val nameEn: String,
    val descriptionRu: String,
    val descriptionEn: String
)

@Entity(tableName = "unit")
data class Unit(
    @PrimaryKey val unitId: Int,
    val nameRu: String,
    val nameEn: String,
    val amount: Int
)

@Entity(primaryKeys = ["ingredientId", "unitId"])
data class IngredientUnitCrossRef(
    val ingredientId: Int,
    val unitId: Int
)

//
@Entity(primaryKeys = ["recipeId", "ingredientId"])
data class RecipeIngredientCrossRef(
    val recipeId: Int,
    val ingredientId: Int
)

//define one to one relationship
data class IngredientAndUnit(
    @Embedded val ingredient: Ingredient,
    @Relation(
        parentColumn = "ingredientId",
        entityColumn = "unitId",
    )
    val unit: Unit,
)

//define one to many relationship
data class RecipeWithIngredientAndUnit(
    @Embedded val recipe: Recipe,
    @Relation(
        entity = Ingredient::class,
        parentColumn = "recipeId",
        entityColumn = "ingredientId",
    )
    val ingredients: List<IngredientAndUnit>
)

//https://stackoverflow.com/questions/45655382/database-schema-for-recipe-ingredient-measurement-amount

//https://developer.android.com/training/data-storage/room/relationships
@Dao
interface RecipeDao {
    @Transaction
    @Query("SELECT * FROM recipe")
    fun getRecipes(): List<RecipeWithIngredientAndUnit>
}