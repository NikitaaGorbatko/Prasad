package nikitagorbatko.example.prasad.database

import androidx.room.*

@Entity(tableName = "ingredients")
data class Ingredients(
    @PrimaryKey val ingredientId: Int,
    val nameRu: String,
    val nameEn: String,
    val descriptionRu: String,
    val descriptionEn: String
)

@Entity(tableName = "recipes")
data class Recipes(
    @PrimaryKey val recipeId: Int,
    val nameRu: String,
    val nameEn: String,
    val technologyRu: String,
    val technologyEn: String
)

@Entity(tableName = "units")
data class Units(
    @PrimaryKey val unitId: Int,
    val nameRu: String,
    val nameEn: String
)

@Entity(tableName = "recipes_ingredients")
class RecipesIngredients(
    @PrimaryKey val recipesIngredientsId: Int,
    @ForeignKey()
)


//https://stackoverflow.com/questions/45655382/database-schema-for-recipe-ingredient-measurement-amount
@Entity(foreignKeys = [ForeignKey(entity = Recipe::class,
    parentColumns = arrayOf("ingredientName"),
    childColumns = arrayOf("ingredientName"))]
)

@Dao
interface IngredientDao {
//    @Query("SELECT * FROM ingredients_table")
//    fun getIngredients(): List<Ingredient>
//
//    @Query("SELECT * FROM recipes_table")
//    fun getRecipes(): List<Recipe>
}