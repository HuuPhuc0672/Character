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

        setData()
      //  recVie1.adapter = FigureAdater(requireContext(),figurelist)
        figureAdater = FigureAdapter(requireContext(),figurelist)
        recVie1.adapter =figureAdater

    }






    fun setData(){
        figurelist.add(Figure(R.drawable.img_1,"$ 2500",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_2,"$ 2400",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_3,"$ 2500",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_4,"$ 2300",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_5,"$ 2000",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_6,"$ 2580",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_7,"$ 2680",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_8,"$ 2500",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_9,"$ 1400",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_10,"$ 2600",getString(R.string.nhanvet)))
        figurelist.add(Figure(R.drawable.img_11,"$ 2540",getString(R.string.nhanvet)))
    }



}