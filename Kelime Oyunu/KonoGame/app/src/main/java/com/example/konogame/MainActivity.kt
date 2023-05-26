package com.example.konogame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startgame(view: View) {
        val intent = Intent(this@MainActivity,GameActivity::class.java)
        startActivity(intent)
    }
    fun leaderboard(view: View) {
        val intent = Intent(this@MainActivity,get::class.java)
        startActivity(intent)

    }

}