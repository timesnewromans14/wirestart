package com.example.wirestart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateActivityIntent = Intent(this, CalculateActivity::class.java)
        val knowledgeActivityIntent = Intent(this, KnowledgeActivity::class.java)

        val calculatorButton = findViewById<Button>(R.id.calculatorButton)
        val knowButton = findViewById<Button>(R.id.knowButton)

        calculatorButton.setOnClickListener {
            startActivity(calculateActivityIntent)
        }

        knowButton.setOnClickListener {
            startActivity(knowledgeActivityIntent)
        }
    }
}
