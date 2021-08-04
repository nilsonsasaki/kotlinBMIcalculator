package com.nilsonsasaki.kotlinbmicalculator

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btCalculate: Button = findViewById(R.id.btCalculate)
        btCalculate.setOnClickListener { (calculate()) }
    }

    private fun calculate() {
        val etHeightInput: EditText = findViewById(R.id.etHeightInput)
        val etWeightInput: EditText = findViewById(R.id.etWeightInput)
        val tvResults: TextView = findViewById(R.id.tvResults)
        val tvBMI: TextView = findViewById(R.id.tvBMI)
        val height: Double = etHeightInput.text.toString().toDouble()
        val weight: Double = etWeightInput.text.toString().toDouble()
        val squaredHeight = height?.pow(2)
        val bmi: String = String.format("%.1f", (weight / squaredHeight))
        val minWeight = String.format("%.1f", 18.5 * squaredHeight)
        val maxWeight = String.format("%.1f", 24.9 * squaredHeight)
        hideKeyboard()
        when {
            bmi.toDouble() > 24.9 -> {
                tvBMI.text = getString(R.string.pt_calculated_above_normal, bmi)
                tvBMI.setTextColor(Color.RED)
            }
            bmi.toDouble() < 18.5 -> {
                tvBMI.text = getString(R.string.pt_calculated_below_normal, bmi)
                tvBMI.setTextColor(Color.RED)
            }
            else -> {
                tvBMI.text = getString(R.string.pt_calculated_normal, bmi)
                tvBMI.setTextColor(Color.GREEN)
            }
        }
        tvResults.text = getString(R.string.pt_bmi_normal_range, minWeight, maxWeight)
    }


    private fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}


