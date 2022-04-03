package com.example.tadribyassin

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.util.ArrayList

class carAdapter(val championList: MutableList<Champion>) :
    RecyclerView.Adapter<ViewHolder>() {


    private lateinit var Nom: TextView
    private lateinit var dispo: TextView
    private lateinit var champPic: ImageView
    private lateinit var prix: TextView
    private lateinit var btnAdd: Button


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_model, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = championList[position].Nom
        val dispo = championList[position].dispo
        val champPic = championList[position].champPic
        val prix = championList[position].prix



        holder.carpic.setImageResource(champPic)
        holder.nom.text = name
        holder.dispo.text = dispo
        holder.prix.text = prix.toString()
        holder.btnadd.setOnClickListener {
            try {
                AppDataBase.getDatabase(holder.itemView.context).championDao().insert(
                    Champion(
                        position,
                        R.drawable.kia_picanto,
                        holder.nom.text.toString(),
                        holder.dispo.text.toString(),
                        80

                    )
                )
            }
            catch (ex: Exception){
                Toast.makeText(holder.itemView.context, "Could not add the car to favorite !", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int {
        return championList.size
    }


}