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



abstract class Animal {
    abstract val image: ImageView
    abstract val food: Food
    abstract val weight: Int
    abstract val habitat: String
    var hunger: Int = 10

    abstract fun makeNoise()
    abstract fun eat()
    abstract fun roam()
    abstract fun sleep()
}

enum class Food {
    GRASS, MEET, FRUITS, VEGETABLES
}

abstract class Hippo: Animal() {
    override var weight: Int = 0
    set(value) {field = if (value > 0) value else -1}
}

class Bird: Hippo() {
    override var weight: Int = 1
    override val image: ImageView
        get() = TODO("Not yet implemented")
    override val food: Food
        get() = TODO("Not yet implemented")
    override val habitat: String
        get() = TODO("Not yet implemented")

    override fun makeNoise() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun roam() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }
}