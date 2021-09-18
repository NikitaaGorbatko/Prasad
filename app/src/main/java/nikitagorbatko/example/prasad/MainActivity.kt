package nikitagorbatko.example.prasad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Dao
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val adapter = RecipesAdapter(Recipes.recipes)
        val manager = LinearLayoutManager(this)

        findViewById<RecyclerView>(R.id.recipes_recycler_view).also {
            it.layoutManager = manager
            //it.adapter = adapter
        }
//
//        Room.databaseBuilder(applicationContext, WordRoomDatabase::class.java, "word_database.db")
//            .createFromAsset("assets/datlabase.db")
//            .build()
        val database = WordRoomDatabase.getDatabase(applicationContext)
        val dao = database.ingredientDao()
        lifecycleScope.launch { // coroutine on Main
            val a = start(dao)// ...back on Main
            Toast.makeText(applicationContext, a.toString(), Toast.LENGTH_LONG).show()
        }

        //val ingredients = dao.getIngredients()



//        val list = WordRoomDatabase.getDatabase(applicationContext).ingredientDao().getIngredients()
//        list.size
        //Toast.makeText(this, ingredients.size.toString(), Toast.LENGTH_LONG).show()
        //I think I should to use room for storage recipes not xml
        // prepopulating the database is a good way to set all data into app
    }

    suspend fun start(dao: IngredientDao) = dao.getIngredients().size.toString()
}