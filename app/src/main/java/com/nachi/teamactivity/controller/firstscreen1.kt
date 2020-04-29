package com.nachi.teamactivity.controller

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.nachi.teamactivity.R
import kotlinx.android.synthetic.main.firstscreen.*
import kotlinx.android.synthetic.main.nav_drawer.*

open class firstscreen1 : LogActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var navView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_drawer)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this, drawerLayout, toolbar, (R.string.open), (R.string.close)
        ) {
        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.searchemployee -> {
                Toast.makeText(applicationContext, "click on setting", Toast.LENGTH_LONG).show()
                true
            }
            R.id.reports -> {
                Toast.makeText(applicationContext, "click on share", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.appdescription -> {
//                    Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                showappdescription()
                return true
            }
            R.id.logout -> {
                val logoutpage = Intent(this, MainActivity::class.java)
                startActivity(logoutpage)
                return true

            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun showappdescription() {
        appdesc.visibility = View.VISIBLE

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.createemployee -> {
                val createemp = Intent(this, Createemployee::class.java)
                startActivity(createemp)
                return true
            }
            R.id.updateemployee -> {
                val updateeemp = Intent(this, Updateemployee::class.java)
                startActivity(updateeemp)
                return true
            }
            R.id.nav_share -> {
                Toast.makeText(this, "Friends clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_send -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}



