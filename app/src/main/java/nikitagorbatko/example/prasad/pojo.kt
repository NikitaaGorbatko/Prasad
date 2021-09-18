package nikitagorbatko.example.prasad

import android.app.Application
import androidx.room.*

@Entity(tableName = "ingredients")
class Ingredient(@PrimaryKey val id: Int, val name: String)

@Entity(tableName = "recipes_table")
class Recipe(@PrimaryKey val recipeName: String, val technology: String)

@Entity(foreignKeys = [ForeignKey(entity = Recipe::class,
    parentColumns = arrayOf("ingredientName"),
    childColumns = arrayOf("ingredientName"))]
)

@Dao
interface IngredientDao {
    @Query("SELECT * FROM ingredients")
    fun getIngredients(): List<Ingredient>
//
//    @Insert()
//    suspend fun insertIngredient(ingredient: Ingredient)
//
//    @Query("DELETE FROM ingredient_table")
//    suspend fun deleteIngredient(ingredient: Ingredient)
}

//object Ingredients {
//    val water = Ingredient("water")
//    val a = Ingredient("get")
//    val basmati = Ingredient("basmati rice")
//    val mung = Ingredient("mung")
//    val gee = Ingredient("gee")
//}

object Recipes: Application() {
//    private val ingredientsSet = mapOf(
//        Ingredients.basmati to 100,
//        Ingredients.mung to 100,
//        Ingredients.gee to 30,
//        Ingredients.water to 1000
//    )

//    val recipes = listOf(
//        Recipe("Кичри", ingredientsSet, "1 - закипятить воду\n" +
//                "2 - добавить маш и варить 30 минут\n" +
//                "3 - добавить рис басмати и варить 15 минут\n" +
//                "4 - в конце готовки добавить столовую ложку ги и соль\n"),
//    )
}
