package com.example.firstpraktika

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var sharedd: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login=findViewById(R.id.editText1)
        password=findViewById((R.id.editText2))
        sharedd=getSharedPreferences("ACCOUNT_FILMS", MODE_PRIVATE)
        if (sharedd.contains("MY_LOGIN_FILM") && sharedd.contains("MY_PASSWORD_FILM")){
            var l=sharedd.getString("MY_LOGIN_FILM","NONE")
            var p=sharedd.getString("MY_PASSWORD_FILM","NONE")
            login.setText(l)
            password.setText(p)
        }
    }
    fun voidite(view: android.view.View){
        if(!sharedd.contains("MY_LOGIN_FILM") && !sharedd.contains("MY_PASSWORD_FILM")){
            if ( login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
                var editing=sharedd.edit()
                editing.putString("MY_LOGIN_FILM",login.text.toString())
                editing.putString("MY_PASSWORD_FILM",password.text.toString())
                editing.apply()
                val intent= Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
            else{
                val alert= AlertDialog.Builder(this)
                    .setTitle("Ошибка").setMessage("У вас не заполненные поля").setPositiveButton("Ok", null).create().show()

            }

        }
        else{
            var l=sharedd.getString("MY_LOGIN_FILM","NONE")
            var p=sharedd.getString("MY_PASSWORD_FILM","NONE")
            login.setText(l)
            password.setText(p)
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)

        }
    }
}