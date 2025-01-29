package rigoberto.lapaz.tecnm.glhf

import android.app.admin.DevicePolicyManager
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import rigoberto.lapaz.tecnm.glhf.*
import rigoberto.lapaz.tecnm.glhf.databinding.FragmentPerfilBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfilFragment : Fragment(), Juegolistener {
    private lateinit var binding:FragmentPerfilBinding
    var jugados = mutableListOf<Juego>()
    var favoritos = mutableListOf<Juego>()
    var porJugar = mutableListOf<Juego>()
    /*val juego1=Juego(
        R.drawable.control,
        "Control",
        "Remedy Entertainment",
        "Winner of over 80 awards, Control is a visually stunning third-person action-adventure that will keep you on the edge of your seat."
    )
    val juego2=Juego(
        R.drawable.forza,
        "Forza Horizon 5",
        "Neversoft",
        "Mejor juego de carreras"
    )
    val juego3=Juego(
        R.drawable.genshin,
        "Genshin Impact",
        "miHoYo",
        "MiAAUUUUU"
    )
    val listafav = listOf(juego1,juego2,juego3)
    val listajugados = listOf(juego3,juego2,juego1)
    val listaporjugar = listOf(juego1)
    val user = Usuario(
        "LuisGamer777",
        listajugados,
        listafav,
        listaporjugar
    )*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPerfilBinding.inflate(layoutInflater)
        val PerfilActivity = this
        GlobalScope.launch {
            val Db = DatabaseJuegos.getInstance(requireContext())
            jugados= Db.JuegosDAO().getLista(1) as MutableList<Juego>
            favoritos= Db.JuegosDAO().getLista(2) as MutableList<Juego>
            porJugar= Db.JuegosDAO().getLista(3) as MutableList<Juego>
            jugados.addAll(Db.JuegosDAO().getLista(4) as MutableList<Juego>)
            favoritos.addAll(Db.JuegosDAO().getLista(4) as MutableList<Juego>)
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(context.applicationContext, 3)
                adapter = adaptadordecarta(jugados, PerfilActivity)
            }
        }


    }
    override fun Onclick(juego: Juego) {
        val intent = Intent(requireContext().applicationContext,Juegoinfo::class.java)
        intent.putExtra(Juego_ID_EXTRA,juego.id)
        startActivity(intent)

    }
    private fun crear() {
        binding = FragmentPerfilBinding.inflate(layoutInflater)
        val PerfilActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context.applicationContext, 3)
            /*adapter = adaptadordecarta(user.jugados, PerfilActivity)*/
        }
    }
    private fun Cargarlista(int: Int){
        if(int==0) {
            val PerfilActivity = this
            binding.recyclerView.adapter=adaptadordecarta(jugados, PerfilActivity)
            }

        else if(int==1) {
            val PerfilActivity = this
            binding.recyclerView.adapter=adaptadordecarta(favoritos, PerfilActivity)
        }
            else if(int==2) {
            val PerfilActivity = this
            binding.recyclerView.adapter=adaptadordecarta(porJugar, PerfilActivity)
            }
        }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val a=view.findViewById<TextView>(R.id.lbluser)
        /*a.text= user.nombre*/
        val tb = view.findViewWithTag<TabItem>("Favoritos")
        binding.btnJuegos.setOnClickListener{
            Cargarlista(0)



        }
        binding.btnFav.setOnClickListener{
            Cargarlista(1)

        }
        binding.btnPorJugar.setOnClickListener{
            Cargarlista(2)

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PerfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PerfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}