package com.example.tadribyassin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoritesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritesFragment : Fragment() {

    lateinit var recylcerChampionAdapter: favoriteAdapter
    lateinit var carRecyclerView: RecyclerView
    lateinit var dataBase: AppDataBase


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_favorites, container, false)

        var champList : MutableList<Champion> = ArrayList()
        dataBase = AppDataBase.getDatabase(requireActivity())

        carRecyclerView = rootView.findViewById(R.id.recycler_champion1)

        champList =  dataBase.championDao().getAllchamps()



        recylcerChampionAdapter = favoriteAdapter(champList)
        carRecyclerView.adapter = recylcerChampionAdapter

        carRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,
            false)


        return rootView
    }

}