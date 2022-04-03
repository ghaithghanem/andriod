package com.example.tadribyassin

import android.app.AlertDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
private lateinit var favorites: Button
private lateinit var rent: Button
private lateinit var profile: Button
lateinit var recylcerChampionAdapter: carAdapter
class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        rent = findViewById(R.id.rent)
        profile = findViewById(R.id.profile)
        favorites = findViewById(R.id.favorites)
        favorites.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.framelayout, FavoritesFragment()).commit()
        }
        profile.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.framelayout, ProfileFragment()).commit()
        }
        rent.setOnClickListener {

            supportFragmentManager.beginTransaction().replace(R.id.framelayout, firstFragment()).commit()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        lateinit var mSharedPref: SharedPreferences
        when(item.itemId){

            R.id.logoutMenu ->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("logout")
                builder.setPositiveButton("Yes"){ dialogInterface, which ->
                    getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit().clear().apply()
                    finish()
                }
                builder.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                builder.create().show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}