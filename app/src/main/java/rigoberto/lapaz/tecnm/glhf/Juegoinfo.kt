package rigoberto.lapaz.tecnm.glhf

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import rigoberto.lapaz.tecnm.glhf.databinding.ActivityJuegoinfoBinding

class Juegoinfo : AppCompatActivity() {
    private lateinit var binding:ActivityJuegoinfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJuegoinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val juegoID = intent.getIntExtra(Juego_ID_EXTRA,-1)
        val juego = juegodeID(juegoID)
        if(juego!=null){
            val imgUri: Uri = Uri.parse("android.resource://rigoberto.lapaz.tecnm.glhf/drawable/f${juego.id}")
            binding.cover.setImageURI(null)
            binding.cover.setImageURI(imgUri)
            binding.title.text=juego.titulo
            binding.descripcion.text=juego.descripcion
            binding.author.text=juego.desarrolladora
            binding.ratingBar.rating = juego.rating.toFloat()
            Verificacion(juego.estado)
            binding.btnAAdirJugado.setOnClickListener() {
                binding.btnAAdirJugado.isEnabled()
                juego.estado=1
                GlobalScope.launch {
                    val Db = DatabaseJuegos.getInstance(applicationContext)
                    Db.JuegosDAO().updateEstado(juego.id,1)
                }
                Verificacion(juego.estado)
            }
            binding.btnFavoritos.setOnClickListener() {
                juego.estado=4
                GlobalScope.launch {
                    val Db = DatabaseJuegos.getInstance(applicationContext)
                    Db.JuegosDAO().updateEstado(juego.id, 4)
                }
                Verificacion(juego.estado)
            }
            binding.btnporJugar.setOnClickListener() {
                juego.estado=3
                GlobalScope.launch {
                    val Db = DatabaseJuegos.getInstance(applicationContext)
                    Db.JuegosDAO().updateEstado(juego.id,3)
                }
                Verificacion(juego.estado)
            }
            binding.btnAtras.setOnClickListener(){
                onBackPressed()
            }
            binding.btnReiniciar.setOnClickListener(){
                juego.estado=0
                GlobalScope.launch {
                    val Db = DatabaseJuegos.getInstance(applicationContext)
                    Db.JuegosDAO().updateEstado(juego.id,0)
                }
                Verificacion(juego.estado)
            }
        }
    }
    private fun Verificacion(int: Int){
        if(int==0){
            binding.btnAAdirJugado.isEnabled=true
            binding.btnFavoritos.isEnabled=true
            binding.btnporJugar.isEnabled=true
            binding.btnReiniciar.isEnabled=false
            binding.btnReiniciar.isVisible=false
            binding.btnAAdirJugado.text="Añadir a Juegos ya jugados"
            binding.btnFavoritos.text="Añadir a Favoritos"
            binding.btnporJugar.text="Añadir a Por Jugar"
        }
        if(int==1){
            binding.btnAAdirJugado.isEnabled=false;
            binding.btnAAdirJugado.text="Ya has añadido este juego"
            binding.btnFavoritos.isEnabled=true
            binding.btnFavoritos.text="Añadir a Favoritos"
            binding.btnporJugar.isEnabled=true
            binding.btnporJugar.text="Añadir a Por Jugar"
            binding.btnReiniciar.isEnabled=true
            binding.btnReiniciar.isVisible=true
        }
        if(int==2){
            binding.btnAAdirJugado.isEnabled=true
            binding.btnAAdirJugado.text="Añadir a Juegos ya jugados"
            binding.btnFavoritos.isEnabled=false
            binding.btnFavoritos.text="Ya has añadido este juego"
            binding.btnporJugar.isEnabled=true
            binding.btnporJugar.text="Añadir a Por Jugar"
            binding.btnReiniciar.isEnabled=true
            binding.btnReiniciar.isVisible=true
        }
        if(int==3){
            binding.btnAAdirJugado.isEnabled=true
            binding.btnAAdirJugado.text="Añadir a Juegos ya jugados"
            binding.btnFavoritos.isEnabled=true
            binding.btnFavoritos.text="Añadir a Favoritos"
            binding.btnporJugar.isEnabled=false
            binding.btnporJugar.text="Ya has añadido este juego"
            binding.btnReiniciar.isEnabled=true
            binding.btnReiniciar.isVisible=true
        }
        if(int==4){
            binding.btnAAdirJugado.isEnabled=false
            binding.btnAAdirJugado.text="Ya has añadido este juego"
            binding.btnFavoritos.isEnabled=false
            binding.btnFavoritos.text="Ya has añadido este juego"
            binding.btnporJugar.isEnabled=true
            binding.btnporJugar.text="Añadir a Por Jugar"
            binding.btnReiniciar.isEnabled=true
            binding.btnReiniciar.isVisible=true
        }
    }
    private fun juegodeID(juegoID: Int):Juego?
    {
        for(juego in Juegolista)
        {
            if(juego.id==juegoID){
                return juego
            }
        }
        return null
    }
}