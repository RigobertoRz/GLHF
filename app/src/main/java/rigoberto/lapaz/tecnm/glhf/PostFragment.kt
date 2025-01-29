package rigoberto.lapaz.tecnm.glhf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import rigoberto.lapaz.tecnm.glhf.databinding.FragmentPostBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentPostBinding.inflate(layoutInflater)

        GlobalScope.launch {
            val Db = DatabaseJuegos.getInstance(requireContext())
            val juegos = Db.JuegosDAO().getNombres()
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item, juegos)
            requireActivity().runOnUiThread {
                with(binding.autoCompleteTextView) {
                    setAdapter(adapter)
                }
            }
        }
        /*
        val adapt = ArrayAdapter(requireContext(),R.layout.comentario_celda, Juegolista)
        with(binding.recyclerView2){

        }*/
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
        binding.btnPost3.setOnClickListener(){
            val principalActivity = this

            GlobalScope.launch {
                val a= binding.textView.text.toString()
                val b= binding.autoCompleteTextView.text.toString()
                val Db = DatabaseJuegos.getInstance(requireContext())
                val juego = Db.JuegosDAO().getJuego(b)
                if(juego!=null && a!=""){
                requireActivity().runOnUiThread {
                    binding.recyclerView2.apply {
                        layoutManager = GridLayoutManager(context.applicationContext, 1)
                        adapter = Adaptadordecomentario(juego, a)
                    }
                }
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PostFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PostFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}