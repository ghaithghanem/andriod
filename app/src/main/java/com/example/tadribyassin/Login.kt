package com.example.tadribyassin

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
const val PREF_NAME = "LOGIN_PREF_CAR"
const val LOGIN = "LOGIN"
const val PASSWORD = "PASSWORD"
const val IS_REMEMBRED = "IS_REMEMBRED"
class Login : AppCompatActivity() {
    private lateinit var buttonLogin: Button
    private lateinit var editTextuser: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var remember_me: CheckBox
    lateinit var mSharedPref: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title="Login";

        setContentView(R.layout.activity_login)
        buttonLogin = findViewById(R.id.buttonLogin)
        editTextuser = findViewById(R.id.editTextuser)
        editTextPassword = findViewById(R.id.editTextPassword)

        remember_me = findViewById(R.id.remember);

        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);


        if (mSharedPref.getBoolean(IS_REMEMBRED, false)){
            navigate()
        }


        buttonLogin.setOnClickListener{
            val user = editTextuser.text
            val password = editTextPassword.text
            if(user.isEmpty()){
                editTextuser.error = "Email required"
                editTextuser.requestFocus()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }



            if (!password.isEmpty() && !user.isEmpty() && remember_me.isChecked()){
                mSharedPref.edit().apply{
                    putBoolean(IS_REMEMBRED, true)
                    putString(LOGIN, user.toString())
                    putString(PASSWORD, password.toString())
                }.apply()
                navigate()
            }
            if (!password.isEmpty() && !user.isEmpty() && !remember_me.isChecked()){
                mSharedPref.edit().apply{
                    putBoolean(IS_REMEMBRED, false)
                    putString(LOGIN, user.toString())
                    putString(PASSWORD, password.toString())
                }.apply()
                navigate()
            }
        }
    }
    private fun navigate(){
        val mainIntent = Intent(this, Home::class.java)
        startActivity(mainIntent)
    }
}
