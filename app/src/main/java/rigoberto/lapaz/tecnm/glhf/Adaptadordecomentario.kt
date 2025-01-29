package rigoberto.lapaz.tecnm.glhf

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rigoberto.lapaz.tecnm.glhf.databinding.ComentarioCeldaBinding

class Adaptadordecomentario(private val juego:Juego,comentario: String)
    :RecyclerView.Adapter<sujetadordecomentario>(){val coment = comentario
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sujetadordecomentario {
        val from = LayoutInflater.from(parent.context)
        val binding = ComentarioCeldaBinding.inflate(from,parent,false)
        return sujetadordecomentario(binding)
    }

    override fun onBindViewHolder(holder: sujetadordecomentario, position: Int) {
        holder.unirJuego(juego,coment)
    }

    override fun getItemCount(): Int {return 1}

    }