package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoButton = findViewById<Button>(R.id.infoButton)
        infoButton.setOnClickListener{
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
        val classesButton = findViewById<Button>(R.id.classesButton)
        classesButton.setOnClickListener{
            val intent = Intent(this, ClassesActivity::class.java)
            startActivity(intent)
        }

    }
}
