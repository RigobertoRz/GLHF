package rigoberto.lapaz.tecnm.glhf


import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import rigoberto.lapaz.tecnm.glhf.databinding.CartaCeldaBinding

class Sujetadordecarta(
    private val cardCellBinding: CartaCeldaBinding,
    private val clickListener: Juegolistener
): RecyclerView.ViewHolder(cardCellBinding.root)
{

    fun unirJuego(juego: Juego){
        val imgUri: Uri = Uri.parse("android.resource://rigoberto.lapaz.tecnm.glhf/drawable/f${juego.id}")
       cardCellBinding.cover.setImageURI(null)
        cardCellBinding.cover.setImageURI(imgUri)
        cardCellBinding.Titulo.text = juego.titulo
        cardCellBinding.Desarrolladora.text = juego.desarrolladora


        cardCellBinding.cardview.setOnClickListener{
            clickListener.Onclick(juego)
        }

    }
}