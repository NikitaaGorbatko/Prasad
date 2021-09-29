package nikitagorbatko.example.prasad.database

import android.content.Context
import android.widget.ImageView
import androidx.room.*

@Database(entities = [Recipe::class, Ingredient::class, Unit::class], version = 1, exportSchema = false)
abstract class RecipeRoomDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: RecipeRoomDatabase? = null

        fun getDatabase(context: Context): RecipeRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeRoomDatabase::class.java,
                    "database.db"
                ).allowMainThreadQueries()
                    .createFromAsset("database.db")
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}