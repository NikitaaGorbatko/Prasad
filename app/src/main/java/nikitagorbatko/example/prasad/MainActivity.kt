package nikitagorbatko.example.prasad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RecipesAdapter(Recipes.recipes)
        val manager = LinearLayoutManager(this)

        findViewById<RecyclerView>(R.id.recipes_recycler_view).also {
            it.layoutManager = manager
            it.adapter = adapter
        }

       //I think I should to use room for storage recipes not xml
        //prepopulating the database is a good way to set all data into app

//        1000 - 700
//        60 -   x
//        42
//
//        5000 - 1380
//        80 -   x
//        22

    }
}