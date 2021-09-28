package nikitagorbatko.example.prasad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nikitagorbatko.example.prasad.database.Ingredient
import nikitagorbatko.example.prasad.database.RecipeWithIngredientAndUnit

class RecipeHolder(view: View): RecyclerView.ViewHolder(view) {
    val nameTextView = view.findViewById<TextView>(R.id.name_text_view)
    val descriptionTextView = view.findViewById<TextView>(R.id.ingredients_text_view)
}

class RecipesAdapter(private val recipes: List<RecipeWithIngredientAndUnit>): RecyclerView.Adapter<RecipeHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return RecipeHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        var ingredients = ""
        for (ingredient in recipes[position].ingredients) {
            ingredients += "${ingredient.ingredient} \n"
        }
        holder.nameTextView.text = recipes[position].toString()
        //holder.descriptionTextView.text = recipes[position].recipe.nameEn
    }

    override fun getItemCount() = recipes.size
}