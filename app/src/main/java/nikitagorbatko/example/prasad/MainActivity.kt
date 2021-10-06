package nikitagorbatko.example.prasad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nikitagorbatko.example.prasad.database.Ingredient
import nikitagorbatko.example.prasad.database.RecipeRoomDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val bundle = bundleOf("context" to applicationContext)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<RecipesFragment>(R.id.fragment_container_view, args = bundle)
            }
        }

    }
}