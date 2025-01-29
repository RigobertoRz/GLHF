package rigoberto.lapaz.tecnm.glhf
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

    @Database(entities = arrayOf(Juego::class), version = 3)
    abstract class DatabaseJuegos : RoomDatabase() {
        abstract fun JuegosDAO(): JuegosDAO
        companion object {
            @Volatile
            private var INSTANCE: DatabaseJuegos? = null

            fun getInstance(context: Context): DatabaseJuegos =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

            private fun buildDatabase(context: Context) =
                Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseJuegos::class.java, "Juegos.db"
                )
                    .createFromAsset("Juegos.db")
                    //.addMigrations()
                    .build()
        }
    }