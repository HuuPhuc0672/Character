package com.example.character.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.character.Adapter.AnimalAdapter
import com.example.character.Mode.Animal
import com.example.character.R

class Man2Fragment : Fragment() {
    private  lateinit var  animal: Animal
    private lateinit var arrayList: ArrayList<Animal>
    private  lateinit var animalAdapter: AnimalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_man2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val rcViDangVat: RecyclerView by lazy { view.findViewById<RecyclerView>(R.id.rcViDangVat) }


        rcViDangVat.setHasFixedSize(true)
        rcViDangVat.layoutManager=LinearLayoutManager(requireContext())

        arrayList= ArrayList()

        setData()



        animalAdapter=AnimalAdapter(requireContext(),arrayList)
        rcViDangVat.adapter=animalAdapter







    }

    fun setData(){
        arrayList.add(Animal(
            "https://photo-cms-kienthuc.zadn.vn/zoom/800/uploaded/hongngan/2016_09_13/c/nhung-loai-dong-vat-moi-toanh-ra-doi-bang-photoshop-1.jpg",
            "voi"))
        arrayList.add(Animal(
            "https://photo-cms-kienthuc.zadn.vn/zoom/800/uploaded/hongngan/2016_09_13/c/nhung-loai-dong-vat-moi-toanh-ra-doi-bang-photoshop-1.jpg",
            "voi"))
        arrayList.add(Animal(
            "https://photo-cms-kienthuc.zadn.vn/zoom/800/uploaded/hongngan/2016_09_13/c/nhung-loai-dong-vat-moi-toanh-ra-doi-bang-photoshop-1.jpg",
            "voi"))
        arrayList.add(Animal(
            "https://photo-cms-kienthuc.zadn.vn/zoom/800/uploaded/hongngan/2016_09_13/c/nhung-loai-dong-vat-moi-toanh-ra-doi-bang-photoshop-1.jpg",
            "voi"))
        arrayList.add(Animal(
            "https://photo-cms-kienthuc.zadn.vn/zoom/800/uploaded/hongngan/2016_09_13/c/nhung-loai-dong-vat-moi-toanh-ra-doi-bang-photoshop-1.jpg",
            "voi"))
        arrayList.add(Animal(
            "https://photo-cms-kienthuc.zadn.vn/zoom/800/uploaded/hongngan/2016_09_13/c/nhung-loai-dong-vat-moi-toanh-ra-doi-bang-photoshop-1.jpg",
            "voi"))

    }
}