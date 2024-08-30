package com.example.lyfecycle


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var bmiTextView: TextView
    private lateinit var bodyImageView: ImageView
    private lateinit var adviceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        bmiTextView = findViewById(R.id.bmiTextView)
        bodyImageView = findViewById(R.id.bodyImageView)
        adviceTextView = findViewById(R.id.adviceTextView)

        val height = intent.getDoubleExtra("HEIGHT", 0.0)
        val weight = intent.getDoubleExtra("WEIGHT", 0.0)
        val bmi = calculateBMI(height, weight)

        bmiTextView.text = getString(R.string.bmi_result, bmi)
        updateUI(bmi)
    }

    private fun calculateBMI(height: Double, weight: Double): Double {
        return weight / (height * height)
    }

    private fun updateUI(bmi: Double) {
        when {
            bmi < 18.5 -> {
                bodyImageView.setImageResource(R.drawable.underweight)
                adviceTextView.text = getString(R.string.advice_underweight)
            }
            bmi in 18.5..24.9 -> {
                bodyImageView.setImageResource(R.drawable.normal)
                adviceTextView.text = getString(R.string.advice_normal)
            }
            else -> {
                bodyImageView.setImageResource(R.drawable.overweight)
                adviceTextView.text = getString(R.string.advice_overweight)
            }
        }
    }
}
