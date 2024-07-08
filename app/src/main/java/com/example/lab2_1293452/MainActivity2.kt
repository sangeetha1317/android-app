package com.example.lab2_1293452

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged

class MainActivity2 : AppCompatActivity() {
    lateinit var editView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        Log.d("lifeCycle 2", "onCreate")

        val bundle = intent.extras
        val data = bundle?.getString("data")
        editView = findViewById<EditText>(R.id.editField)

        if(data != null) {
            editView.setText(data)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle 2", "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle 2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle 2", "onPause")

        val sharedpref = getSharedPreferences("newSharedData", Context.MODE_PRIVATE)
        val editor = sharedpref.edit()
        editor.putString("newData", editView.text.toString())
        editor.commit()

    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle 2", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle 2", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle 2", "onDestroy")
    }
}