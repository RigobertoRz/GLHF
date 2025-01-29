package rigoberto.lapaz.tecnm.glhf

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rigoberto.lapaz.tecnm.glhf.databinding.CartaCeldaBinding

class adaptadordecarta(
    private val juegos: List<Juego>,
    private val clickListener: Juegolistener
    )
    :RecyclerView.Adapter<Sujetadordecarta>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Sujetadordecarta {
        val from = LayoutInflater.from(parent.context)
        val binding =CartaCeldaBinding.inflate(from,parent,false)
        return Sujetadordecarta(binding,clickListener)
    }

    override fun onBindViewHolder(holder: Sujetadordecarta, position: Int) {
        holder.unirJuego(juegos[position])
    }

    override fun getItemCount(): Int =juegos.size
}