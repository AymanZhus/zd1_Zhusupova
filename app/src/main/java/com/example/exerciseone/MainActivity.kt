package com.example.exerciseone

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var sharedd:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login=findViewById(R.id.editText1)
        password=findViewById(R.id.editText2)
        sharedd=getSharedPreferences("Account_MANGAS", MODE_PRIVATE)
        if (sharedd.contains("MY_LOGIN_MANGA") && sharedd.contains("MY_PASSWORD_MANGA")){
            var l =sharedd.getString("MY_LOGIN_MANGA", "NONE")
            var p = sharedd.getString("MY_PASSWORD_MANGA", "NONE")
            login.setText(l)
            password.setText(p)
        }
    }
    fun voidite(view: android.view.View){
        if(!sharedd.contains("MY_LOGIN_MANGA") && !sharedd.contains("MY_PASSWORD_MANGA")) {
            if (login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                var editing = sharedd.edit()
                editing.putString("MY_LOGIN_MANGA", login.text.toString())
                editing.putString("MY_PASSWORD_MANGA", password.text.toString())
                editing.apply()
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            else {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка").setMessage("Поля не заполнены!")
                    .setPositiveButton("ok", null)
                    .create()
                    .show()
            }
        }
        else {
            var Log = sharedd.getString("MY_LOGIN_MANGA", "NONE")
            var pass = sharedd.getString("MY_PASSWORD_MANGA", "NONE")
            login.setText(Log)
            password.setText(pass)
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

}