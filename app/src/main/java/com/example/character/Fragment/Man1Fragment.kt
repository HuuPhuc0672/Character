package com.example.character.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.character.Mode.Figure
import com.example.character.Adapter.FigureAdapter
import com.example.character.R


class Man1Fragment : Fragment() {

    private  lateinit var figurelist : ArrayList<Figure>
    private  lateinit var  figureAdater: FigureAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_man1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recVie1: RecyclerView by lazy { view.findViewById<RecyclerView>(R.id.recVie1) }


        recVie1.setHasFixedSize(true)
        recVie1.layoutManager =GridLayoutManager(requireContext(),2)
        figurelist=ArrayList()


        figurelist.add(Figure(R.drawable.ic_launcher_background,"11111","11"))
        figurelist.add(Figure(R.drawable.ic_launcher_background,"2222","22"))
        figurelist.add(Figure(R.drawable.ic_launcher_background,"3333","33"))
        figurelist.add(Figure(R.drawable.ic_launcher_background,"44444","44"))
        figurelist.add(Figure(R.drawable.ic_launcher_background,"555555","55"))
        figurelist.add(Figure(R.drawable.ic_launcher_background,"66666","66"))
        figurelist.add(Figure(R.drawable.ic_launcher_background,"77777","77"))

      //  recVie1.adapter = FigureAdater(requireContext(),figurelist)

        figureAdater = FigureAdapter(requireContext(),figurelist)
        recVie1.adapter =figureAdater

    }



}