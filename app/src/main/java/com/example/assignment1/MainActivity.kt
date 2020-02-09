package com.example.assignment1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.text.InputFilter
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    private val nameKey = "name"
    private val ageKey = "age"
    private val originKey = "origin"
    private val osKey = "os"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        editor.putString(ageKey, ageEditText.text.toString())
        //Origin
        val originSpinner = findViewById<Spinner>(R.id.originSpinner)
        editor.putInt(originKey, originSpinner.selectedItemPosition)
        //OS
        val osSpinner = findViewById<Spinner>(R.id.osSpinner)
        editor.putInt(osKey, osSpinner.selectedItemPosition)
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
        findViewById<EditText>(R.id.ageEditText).setText(ageLoadStr)
        //Origin
        val originLoadIdx = sharedPreferences.getInt(originKey, 0)
        findViewById<Spinner>(R.id.originSpinner).setSelection(originLoadIdx)
        //OS
        val osLoadIdx = sharedPreferences.getInt(osKey, 0)
        findViewById<Spinner>(R.id.osSpinner).setSelection(osLoadIdx)
    }
}
