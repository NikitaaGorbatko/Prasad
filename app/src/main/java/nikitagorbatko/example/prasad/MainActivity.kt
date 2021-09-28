package nikitagorbatko.example.prasad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nikitagorbatko.example.prasad.database.RecipeRoomDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = RecipeRoomDatabase.getDatabase(applicationContext)
        val dao = db.recipeDao()
        lateinit var adapter: RecipesAdapter
        val recipes = dao.getRecipes()
        lateinit var recipesRecyclerView: RecyclerView

        recipesRecyclerView = findViewById<RecyclerView>(R.id.recipes_recycler_view).also {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = RecipesAdapter(recipes)
        }
    }
}