package com.petra.chat2fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sender = Sender()
        supportFragmentManager.beginTransaction().replace(R.id.nav_container,sender).commit()
    }
}