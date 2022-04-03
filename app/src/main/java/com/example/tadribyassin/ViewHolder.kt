package com.example.tadribyassin

import android.content.ContentValues
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
val carpic = itemView.findViewById<ImageView>(R.id.champPic)
    val nom = itemView.findViewById<TextView>(R.id.Nom)

    val dispo = itemView.findViewById<TextView>(R.id.dispo)
    val prix = itemView.findViewById<TextView>(R.id.prix)
    val btnadd = itemView.findViewById<ImageView>(R.id.btnadd)

}