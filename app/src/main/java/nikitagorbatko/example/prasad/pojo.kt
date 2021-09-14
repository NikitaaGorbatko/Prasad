package nikitagorbatko.example.prasad

import android.app.Application

data class Recipe(val name: String, val ingredients: Map<Ingredient, Int>, val technology: String)

data class Ingredient(val name: String)

object Ingredients {
    val water = Ingredient("Water")
    val a = Ingredient("get")
//    val basmati = Ingredient(resources.getString(R.string.basmati_rice))
//    val mung = Ingredient(resources.getString(R.string.mung))
    val gi = Ingredient("Gi")
//    val chickpea = Ingredient(getString(R.string.chickpea))
//    val brownRice = Ingredient(getString(R.string.brown_rice))
//    val corn = Ingredient(getString(R.string.corn))
//    val rye = Ingredient(getString(R.string.rye))
//    val apple = Ingredient(getString(R.string.apple))
//    val orange = Ingredient(getString(R.string.orange))
//    val banana = Ingredient(getString(R.string.banana))
}

object Recipes: Application() {
    private val ingredientsSet = mapOf(
        Ingredients.gi to 30,
        Ingredients.water to 1000
    )

    val recipes = listOf(
        Recipe("Булочки", ingredientsSet, "1 - boil the water" +
                "2 - put into the pot mung, wait for 30 minutes" +
                "3 - put into the pot basmati, wait for 15 minutes" +
                "4 - at the end add gi oil, and salt"),
    )
}

//val avocadoSalad = Recipe("Avocado salad", Ingredients.ingredients, "description")

