package com.example.assignment2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private val nameKey = "name"
    private val emailKey = "email"
    private val idKey = "id"

    private val cs596Key = "596"
    private val cs605Key = "605"
    private val cs615Key = "615"
    private val cs646Key = "646"
    private val cs696Key = "696"

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
        val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)
        //Load data from app SharedPreferences
        //Name
        val nameLoadStr = sharedPreferences.getString(nameKey, "Unset")
        findViewById<TextView>(R.id.nameTextView).setText(nameLoadStr)

        //email
        val emailLoadStr = sharedPreferences.getString(emailKey, "Unset")
        findViewById<TextView>(R.id.emailTextView).setText(emailLoadStr)
        //ID
        val idLoadStr = sharedPreferences.getString(idKey, "Unset")
        findViewById<TextView>(R.id.idTextView).setText(idLoadStr)

        //CS596
        val cs596Check = sharedPreferences.getBoolean(cs596Key, false)
        if (cs596Check == true){
            findViewById<TextView>(R.id.textView596).visibility = View.VISIBLE
        }else{
            findViewById<TextView>(R.id.textView596).visibility = View.GONE
        }

        //CS605
        val cs605Check = sharedPreferences.getBoolean(cs605Key, false)
        if (cs605Check == true){
            findViewById<TextView>(R.id.textView605).visibility = View.VISIBLE
        }else{
            findViewById<TextView>(R.id.textView605).visibility = View.GONE
        }

        //CS615
        val cs615Check = sharedPreferences.getBoolean(cs615Key, false)
        if (cs615Check == true){
            findViewById<TextView>(R.id.textView615).visibility = View.VISIBLE
        }else{
            findViewById<TextView>(R.id.textView615).visibility = View.GONE
        }

        //CS646
        val cs646Check = sharedPreferences.getBoolean(cs646Key, false)
        if (cs646Check == true){
            findViewById<TextView>(R.id.textView646).visibility = View.VISIBLE
        }else{
            findViewById<TextView>(R.id.textView646).visibility = View.GONE
        }

        //CS696
        val cs696Check = sharedPreferences.getBoolean(cs696Key, false)
        if (cs696Check == true){
            findViewById<TextView>(R.id.textView696).visibility = View.VISIBLE
        }else{
            findViewById<TextView>(R.id.textView696).visibility = View.GONE
        }
    }
}
