package rigoberto.lapaz.tecnm.glhf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rigoberto.lapaz.tecnm.glhf.Juego_ID_EXTRA
import rigoberto.lapaz.tecnm.glhf.databinding.FragmentDetallesBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Detalles.newInstance] factory method to
 * create an instance of this fragment.
 */
class Detalles : Fragment() {
    private lateinit var binding: FragmentDetallesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDetallesBinding.inflate(layoutInflater)

        val JuegoID = requireActivity().intent.getIntExtra(Juego_ID_EXTRA,-1)
        /*val juego = juegodeID(JuegoID)*/
       /* if(juego!=null){
            //binding.cover.setImageResource(juego.portada)
            binding.title.text=juego.titulo
            binding.descripcion.text=juego.descripcion
            binding.author.text=juego.desarrolladora
        }*/
    }
   /* private fun juegodeID(juegoID: Int):Juego?
    {
        for(juego in Juegolista)
        {
            if(juego.id==juegoID){
                return juego
            }
        }
        return null
    }*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Detalles.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Detalles().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}