package com.example.colorguessinggame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterColors(var colorsList: List<Color>):
    RecyclerView.Adapter<RecyclerAdapterColors.ColorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.color_item_view,parent,false)
        return  ColorsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ColorsViewHolder, position: Int) {
        var currentColor = colorsList[position]
        holder.ivColorImage.setImageResource(currentColor.colorImage)
        holder.tvColorName.text = currentColor.colorName
    }

    override fun getItemCount(): Int {
        return colorsList.size
    }


    class ColorsViewHolder(itemView: View ): RecyclerView.ViewHolder(itemView){
        var ivColorImage = itemView.findViewById<ImageView>(R.id.ivColorImage)
        var tvColorName = itemView.findViewById<TextView>(R.id.tvColorName)
    }
}