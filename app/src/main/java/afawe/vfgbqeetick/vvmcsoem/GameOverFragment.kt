package com.huda.kickfoot

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import afawe.vfgbqeetick.vvmcsoem.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameOverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameOverFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var imel1: String? = null
    private var imel2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imel1 = it.getString(ARG_PARAM1)
            imel2 = it.getString(ARG_PARAM2)
        }
        val vv="asdfasdfa"
        vv.equals("as")
        var asffawew=7
        asffawew+=129
        println(asffawew)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<ImageView>(R.id.returnMonent)

        button?.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {
        println("afaf")
        Log.d("fa","adfa")
        for (i in 1..12){
            print("vv")
        }
        return inflater.inflate(R.layout.fragment_game_over, container, false)


        // Использование условных конструкций для различных сценариев
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GameOverFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameOverFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}