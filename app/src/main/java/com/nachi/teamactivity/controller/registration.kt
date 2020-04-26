package com.nachi.teamactivity.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.nachi.teamactivity.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.registration
import kotlinx.android.synthetic.main.registration.*

public class Registration : LogActivity() {

         lateinit var handler:Registrationdb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)
        handler = Registrationdb(this)
        registrationscreen.setOnClickListener() {
            handler.insertregisterdata(name.text.toString(), password.text.toString())
            val startpage = Intent(this, MainActivity::class.java)
            startActivity(startpage)

        }
        deleteuser.setOnClickListener(){
            if(handler.updateegisterdata(name.text.toString(),password.text.toString())) {
                Toast.makeText(applicationContext, "User deleted successfully", Toast.LENGTH_LONG)
                    .show()
                val startpage = Intent(this, MainActivity::class.java)
                startActivity(startpage)
            }else{
                Toast.makeText(applicationContext, "User not exists", Toast.LENGTH_LONG)
                    .show()
            }
        }
        back.setOnClickListener(){
            val startpage = Intent(this, MainActivity::class.java)
            startActivity(startpage)
        }
    }
    }