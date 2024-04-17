package com.example.wirestart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KnowledgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge)

        val TCPActivityIntent = Intent(this, TCPActivity::class.java)
        val UDPActivityIntent = Intent(this, UDPActivity::class.java)
        val STPActivityIntent = Intent(this, STPActivity::class.java)

        val tcpButton = findViewById<Button>(R.id.tcpButton)
        val udpButton = findViewById<Button>(R.id.udpButton)
        val stpButton = findViewById<Button>(R.id.stpButton)

        tcpButton.setOnClickListener {
            startActivity(TCPActivityIntent)
        }

        udpButton.setOnClickListener {
            startActivity(UDPActivityIntent)
        }

        stpButton.setOnClickListener {
            startActivity(STPActivityIntent)
        }
    }
}