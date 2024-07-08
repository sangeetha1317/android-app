package com.example.lab2_1293452

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var textGoal: TextView
    lateinit var editButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editButton = findViewById<Button>(R.id.editId)
        textGoal = findViewById<TextView>(R.id.txtId)

        Log.d("lifeCycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "onResume")

        val shared = getSharedPreferences("newSharedData", Context.MODE_PRIVATE)
        val newText = shared.getString("newData", textGoal.text.toString())
        textGoal.setText(newText)

        editButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val bundle = Bundle()
            bundle.putString("data", newText.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "onDestroy")
    }
}