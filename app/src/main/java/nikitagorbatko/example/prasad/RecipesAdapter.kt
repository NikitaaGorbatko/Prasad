package nikitagorbatko.example.prasad

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nikitagorbatko.example.prasad.database.Recipe
import nikitagorbatko.example.prasad.database.RecipeDao

class RecipeHolder(view: View): RecyclerView.ViewHolder(view) {
    val nameTextView = view.findViewById<TextView>(R.id.name_text_view)
    val descriptionTextView = view.findViewById<TextView>(R.id.ingredients_text_view)
}

class RecipesAdapter(private val recipes: List<Recipe>, private val dao: RecipeDao): RecyclerView.Adapter<RecipeHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return RecipeHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        val recipe = recipes[position]

        holder.nameTextView.text = recipe.nameRu
        holder.descriptionTextView.text = recipe.technologyRu
        holder.nameTextView.setOnClickListener {
            dao.getIngredients(recipe.recipeId).toString()
        }
//        holder.itemView.setOnClickListener {
//            holder.descriptionTextView.text = dao.getIngredients(recipe.recipeId).toString()
//        }
    }

    override fun getItemCount() = recipes.size
}