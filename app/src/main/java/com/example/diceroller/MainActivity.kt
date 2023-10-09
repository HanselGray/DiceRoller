package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tossDice: Button = findViewById(R.id.tossDice)
        tossDice.setOnClickListener {
            Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT).show()
            result = findViewById(R.id.textView)
            rollDice()
        }
    }



    private fun rollDice() {
        val dice = Dice(16)       
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int = 6) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}