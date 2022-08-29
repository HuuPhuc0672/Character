package com.example.character.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.character.DetailActivity
import com.example.character.Mode.Animal
import com.example.character.Mode.Figure
import com.example.character.R

class AnimalAdapter (
    val context: Context,
    private  val  animallist:ArrayList<Animal>):
    RecyclerView.Adapter<AnimalAdapter.FoodviewHoolder>() {



    class FoodviewHoolder(itemView: View):RecyclerView.ViewHolder(itemView){

         val imgDongv: ImageView by lazy { itemView.findViewById<ImageView>(R.id.img_dongv) }
         val txtTenDv: TextView by lazy { itemView.findViewById<TextView>(R.id.txt_tenDv) }
         val btnDownload: TextView by lazy { itemView.findViewById<TextView>(R.id.btn_download) }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodviewHoolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal,parent,false)
        return FoodviewHoolder(view)
    }

    override fun onBindViewHolder(holder: FoodviewHoolder, position: Int) {
        val animal= animallist[position]

        Glide.with(context).load(animal.imgedv).centerCrop().into(holder.imgDongv)
        holder.txtTenDv.text=animal.nameanimal
        holder.btnDownload.setOnClickListener {

        }

        //holder.ttxt2.text=figure.money.toString()




    }

    override fun getItemCount(): Int {
        return animallist.size
    }
}