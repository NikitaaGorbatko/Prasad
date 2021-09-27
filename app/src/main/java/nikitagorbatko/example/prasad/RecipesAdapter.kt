package nikitagorbatko.example.prasad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nikitagorbatko.example.prasad.database.Ingredient

class RecipeHolder(view: View): RecyclerView.ViewHolder(view) {
    val nameTextView = view.findViewById<TextView>(R.id.name_text_view)
    val descriptionTextView = view.findViewById<TextView>(R.id.ingredients_text_view)
}

class RecipesAdapter(private val ingredients: List<Ingredient>): RecyclerView.Adapter<RecipeHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return RecipeHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        //recipes[position].ingredients.forEach({(k,v) -> run { ingredients += "•" + k.name + " " } })
        //holder.nameTextView.text = recipes[position].name
        holder.descriptionTextView.text = ingredients[position].name
    }

    override fun getItemCount() = ingredients.size
}