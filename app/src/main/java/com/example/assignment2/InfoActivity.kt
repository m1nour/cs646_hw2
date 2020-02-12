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
    private val emailKey = "email"
    private val idKey = "id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }

    override fun onPause() {
        super.onPause()
        //Save data in app SharedPreferences
        val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        //Name
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        editor.putString(nameKey, nameEditText.text.toString())
        //email
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        editor.putString(emailKey, emailEditText.text.toString())
        //ID
        val idEditText = findViewById<EditText>(R.id.idEditText)
        editor.putString(idKey, idEditText.text.toString())
        editor.commit()
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)
        //Load data from app SharedPreferences
        //Name
        val nameLoadStr = sharedPreferences.getString(nameKey, "")
        findViewById<EditText>(R.id.nameEditText).setText(nameLoadStr)
        //email
        val emailLoadStr = sharedPreferences.getString(emailKey, "")
        findViewById<EditText>(R.id.emailEditText).setText(emailLoadStr)
        //ID
        val idLoadStr = sharedPreferences.getString(idKey, "")
        findViewById<EditText>(R.id.idEditText).setText(idLoadStr)
    }
}
