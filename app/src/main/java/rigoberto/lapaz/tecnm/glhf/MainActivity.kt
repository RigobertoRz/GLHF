package rigoberto.lapaz.tecnm.glhf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext, DatabaseJuegos::class.java, "Juegos"
        ).build()
        GlobalScope.launch {
            val Db = DatabaseJuegos.getInstance(applicationContext)
            Juegolista= Db.JuegosDAO().getAll() as MutableList<Juego>
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.principalFragment, R.id.logFragment, R.id.postFragment,R.id.perfilFragment), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.menu.getItem(0).setOnMenuItemClickListener {
            var parametros = Bundle()
            navController.navigate(R.id.principalFragment, parametros)
            true
        }
        navView.menu.getItem(1).setOnMenuItemClickListener {
            var parametros = Bundle()
            navController.navigate(R.id.perfilFragment, parametros)
            true
        }
        navView.menu.getItem(2).setOnMenuItemClickListener {
            var parametros = Bundle()
            navController.navigate(R.id.postFragment, parametros)
            true
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_lateral, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    }
