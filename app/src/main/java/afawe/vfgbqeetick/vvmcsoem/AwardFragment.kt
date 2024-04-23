package com.huda.kickfoot

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import afawe.vfgbqeetick.vvmcsoem.R
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AwardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AwardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var imel1: String? = null
    private var imel2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imel1 = it.getString(ARG_PARAM1)
            imel2 = it.getString(ARG_PARAM2)
        }
        val result = 43

        // Итерирование через коллекцию и выполнение действий
        val list = listOf(1, 2, 3, 4, 5)
        for (item in list) {
            // Дополнительные действия с элементом коллекции
            println("Item: $item")
        }

        // Использование условных конструкций для различных сценариев
        when (result) {
            in 1..10 -> println("Результат находится в диапазоне от 1 до 10")
            in 11..20 -> println("Результат находится в диапазоне от 11 до 20")
            else -> println("Результат не входит в указанные диапазоны")

            // Дополнительные ветви для условной конструкции
        }

        val hrh="asfasd"
        hrh.plus("a")
        val rr=hrh.length
        println(rr)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<ImageView>(R.id.returnMonent)

        // Добавить слушатель событий для кнопки
        button?.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            // Обработка нажатия кнопки
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_award, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WinFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AwardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}