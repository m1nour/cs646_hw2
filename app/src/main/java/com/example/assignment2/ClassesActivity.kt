package com.example.assignment2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class ClassesActivity : AppCompatActivity() {

    private val cs596Key = "596"
    private val cs605Key = "605"
    private val cs615Key = "615"
    private val cs646Key = "646"
    private val cs696Key = "696"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classes)
    }

    override fun onPause() {
        super.onPause()
        //Save data in app SharedPreferences
        val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        //CS596
        val cs596CheckBox = findViewById<CheckBox>(R.id.checkBox596)
        editor.putBoolean(cs596Key, cs596CheckBox.isChecked)
        //CS605
        val cs605CheckBox = findViewById<CheckBox>(R.id.checkBox605)
        editor.putBoolean(cs605Key, cs605CheckBox.isChecked)
        //CS615
        val cs615CheckBox = findViewById<CheckBox>(R.id.checkBox615)
        editor.putBoolean(cs615Key, cs615CheckBox.isChecked)
        //CS646
        val cs646CheckBox = findViewById<CheckBox>(R.id.checkBox646)
        editor.putBoolean(cs646Key, cs646CheckBox.isChecked)
        //CS696
        val cs696CheckBox = findViewById<CheckBox>(R.id.checkBox696)
        editor.putBoolean(cs696Key, cs696CheckBox.isChecked)
        editor.commit()
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)
        //Load data from app SharedPreferences
        //CS596
        val cs596Check = sharedPreferences.getBoolean(cs596Key, false)
        findViewById<CheckBox>(R.id.checkBox596).isChecked = cs596Check
        //CS605
        val cs605Check = sharedPreferences.getBoolean(cs605Key, false)
        findViewById<CheckBox>(R.id.checkBox605).isChecked = cs605Check
        //CS615
        val cs615Check = sharedPreferences.getBoolean(cs615Key, false)
        findViewById<CheckBox>(R.id.checkBox615).isChecked = cs615Check
        //CS646
        val cs646Check = sharedPreferences.getBoolean(cs646Key, false)
        findViewById<CheckBox>(R.id.checkBox646).isChecked = cs646Check
        //CS696
        val cs696Check = sharedPreferences.getBoolean(cs696Key, false)
        findViewById<CheckBox>(R.id.checkBox696).isChecked = cs696Check
    }
}
