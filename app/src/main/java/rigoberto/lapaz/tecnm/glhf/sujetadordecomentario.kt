package rigoberto.lapaz.tecnm.glhf

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import rigoberto.lapaz.tecnm.glhf.databinding.ComentarioCeldaBinding

class sujetadordecomentario(
    private val comentarioCeldaBinding: ComentarioCeldaBinding
):RecyclerView.ViewHolder(comentarioCeldaBinding.root) {
    fun unirJuego(juego: Juego,string: String){
        val imgUri: Uri = Uri.parse("android.resource://rigoberto.lapaz.tecnm.glhf/drawable/f${juego.id}")
        comentarioCeldaBinding.cover.setImageURI(null)
        comentarioCeldaBinding.cover.setImageURI(imgUri)
        comentarioCeldaBinding.Titulo.text="USUARIO ha hecho un comentario sobre el juego:"+juego.titulo
        comentarioCeldaBinding.Comentario.text=string
        comentarioCeldaBinding.ratingBar.rating = juego.rating.toFloat()
    }
}