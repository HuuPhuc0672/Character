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
import com.example.character.Mode.Figure
import com.example.character.R

class FigureAdapter (
    val context: Context,
    private  val  fingureliset:ArrayList<Figure>):
    RecyclerView.Adapter<FigureAdapter.FoodviewHoolder>() {



    class FoodviewHoolder(itemView: View):RecyclerView.ViewHolder(itemView){
          val cardView: CardView =itemView.findViewById<CardView>(R.id.card_view)
         val imgAnhNha: ImageView = itemView.findViewById<ImageView>(R.id.img_anhNha)
         val txtGia: TextView = itemView.findViewById<TextView>(R.id.txt_gia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodviewHoolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_figure,parent,false)
        return FoodviewHoolder(view)
    }

    override fun onBindViewHolder(holder: FoodviewHoolder, position: Int) {
        val figure= fingureliset[position]

        Glide.with(context).load(figure.imge).centerCrop().into(holder.imgAnhNha)
        holder.txtGia.text= figure.money

        //holder.ttxt2.text=figure.money.toString()



        holder.cardView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            val image: Int = figure.imge
            val money : String = figure.money
            val namefigure:String=figure.namefigure


            intent.putExtra("image",image)
            intent.putExtra("money",money)
            intent.putExtra("namefigure",namefigure)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return fingureliset.size
    }
}