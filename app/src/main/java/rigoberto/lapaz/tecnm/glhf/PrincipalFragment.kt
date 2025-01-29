package rigoberto.lapaz.tecnm.glhf

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import rigoberto.lapaz.tecnm.glhf.*
import rigoberto.lapaz.tecnm.glhf.databinding.FragmentPrincipalBinding
import kotlin.coroutines.coroutineContext
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PrincipalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrincipalFragment : Fragment(), Juegolistener {
    private lateinit var binding: FragmentPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPrincipalBinding.inflate(layoutInflater)
            val principalActivity = this
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(context.applicationContext, 2)
                adapter = adaptadordecarta(Juegolista,principalActivity)

        }
            /*armarJuegos()*/

    }
    override fun Onclick(juego: Juego) {
        val intent = Intent(requireContext().applicationContext,Juegoinfo::class.java)
        intent.putExtra(Juego_ID_EXTRA,juego.id)
        startActivity(intent)
    }
    /*private fun armarJuegos() {
        val juego1=Juego(
            R.drawable.control,
            "Control",
            "Remedy Entertainment",
            "Winner of over 80 awards, Control is a visually stunning third-person action-adventure that will keep you on the edge of your seat."
        )
        Juegolista.add(juego1)
        val juego2=Juego(
            R.drawable.forza,
            "Forza Horizon 5",
            "Neversoft",
            "Mejor juego de carreras"
        )
        Juegolista.add(juego2)
        val juego3=Juego(
            R.drawable.genshin,
            "Genshin Impact",
            "Mihoyo",
            "aaaaaaaaaaaaaaa"
        )
        Juegolista.add(juego3)
        val juego4=Juego(
            R.drawable.farcry,
            "farcry",
            "ubisoft",
            "aaaaaaaaaa"
        )
        Juegolista.add(juego4)
        val juego5=Juego(
            R.drawable.vanguard,
            "COD Vanguard",
            "Treyarch",
            "aaaaaaaaa"
        )
        Juegolista.add(juego5)
        val juego6=Juego(
            R.drawable.forza,
            "farcry",
            "ubisoft",
            "aaaaaaaaa"
        )
        Juegolista.add(juego6)
        val juego7=Juego(
            R.drawable.forza,
            "farcry",
            "ubisoft",
            "aaaaaaaa"
        )
        Juegolista.add(juego7)

    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.textView3.text = Juegolista[0].titulo*/
        val btnPerfil = view.findViewWithTag<TabItem>("tb1")
        val btnInicio = view.findViewWithTag<TabItem>("tb2")
        val btnPost = view.findViewWithTag<TabItem>("tb3")
        /*btnPerfil.setOnClickListener(){
            val navController = requireActivity().findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.action_principalFragment_to_perfilFragment)
        }
        btnPost.setOnClickListener(){
            val navController = requireActivity().findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.action_principalFragment_to_postFragment)
        }*/

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PrincipalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrincipalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}