package com.nachi.teamactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

public class MainActivity : LogActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById<EditText>(R.id.empid)
        username.isPressed()


        siginin.setOnClickListener{
            val username1 = username.text.toString()

            if(username1=="593083") {
                val startpage = Intent(this, firstscreen1::class.java)
                startActivity(startpage)
            }
        }


    }
}
