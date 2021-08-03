package com.nilsonsasaki.kotlinbmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btCalculate: Button = findViewById(R.id.btCalculate)
        btCalculate.setOnClickListener{(calculate())}
    }
    private fun calculate(){
        val etHeightInput: EditText = findViewById(R.id.etHeightInput)
        val etWeightInput: EditText = findViewById(R.id.etWeightInput)


    }
}