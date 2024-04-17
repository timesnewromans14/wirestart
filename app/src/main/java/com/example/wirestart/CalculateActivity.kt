package com.example.wirestart

import android.annotation.SuppressLint
import android.text.InputFilter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CalculateActivity : AppCompatActivity() {

    private lateinit var binaryIPEditText: EditText
    private lateinit var convertButton: Button
    private lateinit var standardIPTextView: TextView
    val maxLength = 32

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        binaryIPEditText = findViewById(R.id.binaryIPEditText)
        convertButton = findViewById(R.id.convertButton)
        standardIPTextView = findViewById(R.id.standardIPTextView)

        // Ограничение ввода только на 1 и 0
        val filters = arrayOf(InputFilter { source, start, end, dest, dstart, dend ->
            for (i in start until end) {
                if (!(source[i].isDigit() && !(source[i] != '0' && source[i] != '1'))) {
                    return@InputFilter ""
                }
            }
            source
        })

        binaryIPEditText.filters = arrayOf(InputFilter.LengthFilter(maxLength))


        convertButton.setOnClickListener {
            val binaryIP = binaryIPEditText.text.toString().replace(".", "")
            val octets = binaryIP.chunked(8)
            val standardIP = octets.joinToString(".") { Integer.parseInt(it, 2).toString() }
            standardIPTextView.text = "Стандартный IP-адрес: $standardIP"
        }

        binaryIPEditText.requestFocus()
    }
}