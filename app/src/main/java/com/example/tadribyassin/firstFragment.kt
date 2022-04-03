package com.example.tadribyassin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast.makeText as makeText1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [firstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class firstFragment : Fragment() {


    lateinit var recylcerChampionAdapter: carAdapter
    lateinit var carRecyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_first, container, false)

        var champList: MutableList<Champion> = ArrayList()
        carRecyclerView = rootView.findViewById(R.id.recycler_champion)

        champList.add(Champion(id=0 ,champPic = R.drawable.kia_picanto, Nom = "kia picanto", dispo = "DISPONIBLE",prix = 120))
        champList.add(Champion(id=2 ,champPic = R.drawable.kia_rio, Nom = "kia_rio", dispo = "DISPONIBLE",prix = 1250 ))
        champList.add(Champion(id= 3,champPic = R.drawable.polo8, Nom = "polo8", dispo = "DISPONIBLE",prix = 412440 ))
        champList.add(Champion(id= 4,champPic = R.drawable.polo8, Nom = "renault_symbol", dispo = "DISPONIBLE",prix = 519620 ))
        champList.add(Champion(id= 5,champPic = R.drawable.seat_ibiza, Nom = "seat_ibiza", dispo = "DISPONIBLE",prix = 91066 ))
        champList.add(Champion(id= 6,champPic = R.drawable.polo8, Nom = "renault_symbol", dispo = "DISPONIBLE",prix = 61033 ))
        recylcerChampionAdapter = carAdapter(champList)
        carRecyclerView.adapter = recylcerChampionAdapter

        carRecyclerView.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false
        )


        return rootView
    }




}