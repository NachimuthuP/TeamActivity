package com.nachi.teamactivity.controller

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.nachi.teamactivity.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.registration
import kotlinx.android.synthetic.main.registration.*

public class MainActivity : LogActivity() {

    lateinit var handler3:Registrationdb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registration.setOnClickListener {
                val startpage1 = Intent(this, Registration::class.java)
                startActivity(startpage1)
        }
                handler3 = Registrationdb(this)
                siginin.setOnClickListener() {
                    if (loginempid.text.isBlank() || loginpassword.text.isBlank()) {
                        Toast.makeText(
                            applicationContext,
                            "Please enter Emp ID & Password",
                            Toast.LENGTH_LONG
                        ).show()}
                        else if(handler3.registeruserpresent(
                        loginempid.text.toString(),
                        loginpassword.text.toString()
                    )) {
                        val startpage = Intent(this, firstscreen1::class.java)
                    startActivity(startpage)
                    }
                    else{
                        Toast.makeText(applicationContext, "Emp Id or Password invalid", Toast.LENGTH_LONG).show()

                    }

                }


//        val username = findViewById<EditText>(R.id.)
//                if (username1 == "593083" && password =="abc") {
//
//                }
//            }
//

           }



    }

