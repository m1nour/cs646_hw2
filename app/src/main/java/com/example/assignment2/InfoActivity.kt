package com.example.assignment2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner


class InfoActivity : AppCompatActivity() {

    private val nameKey = "name"
    private val ageKey = "age"
    private val originKey = "origin"
    private val osKey = "os"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val homeButton = findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val classesButton = findViewById<Button>(R.id.classesButton)
        classesButton.setOnClickListener {
            val intent = Intent(this, ClassesActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onPause() {
        super.onPause()
        //Save data in app SharedPreferences
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        //Name
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        editor.putString(nameKey, nameEditText.text.toString())
        //Age
        val ageEditText = findViewById<EditText>(R.id.emailEditText)
        editor.putString(ageKey, ageEditText.text.toString())
        editor.commit()
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        //Load data from app SharedPreferences
        //Name
        val nameLoadStr = sharedPreferences.getString(nameKey, "")
        findViewById<EditText>(R.id.nameEditText).setText(nameLoadStr)
        //Age
        val ageLoadStr = sharedPreferences.getString(ageKey, "")
        findViewById<EditText>(R.id.emailEditText).setText(ageLoadStr)
    }
}
