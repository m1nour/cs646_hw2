package com.example.assignment2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val nameKey = "name"
    private val emailKey = "email"
    private val idKey = "id"

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
    override fun onResume() {
        super.onResume()
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        //Load data from app SharedPreferences
        //Name
        val nameLoadStr = sharedPreferences.getString(nameKey, "Unset")
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        nameTextView.setOnClickListener{
            nameTextView.text = nameLoadStr;
        }
        //email
        val emailLoadStr = sharedPreferences.getString(emailKey, "Unset")
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        emailTextView.setOnClickListener{
            emailTextView.text = emailLoadStr
        }
        //ID
        val idLoadStr = sharedPreferences.getString(idKey, "Unset")
        val idTextView = findViewById<TextView>(R.id.idTextView)
        idTextView.setOnClickListener{
            idTextView.text = idLoadStr
        }
    }
}
