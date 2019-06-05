package com.example.kotlinlangplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinlangplayground.logic.FlipFlopLogic

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val btnMatrix = FlipFlopLogic()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        field3.setOnClickListener {
            val intent = Intent(this, FieldTrieToTrie::class.java)
            startActivity(intent)
        }
        field5.setOnClickListener {
            val intent = Intent(this, FieldFiveToFive::class.java)
            startActivity(intent)
        }
        field7.setOnClickListener {
            val intent = Intent(this, FieldSevenToSeven::class.java)
            startActivity(intent)
        }
    }
}

