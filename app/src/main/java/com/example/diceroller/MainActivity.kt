package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var result: TextView
    private lateinit var diceFace: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tossDice: Button = findViewById(R.id.tossDice)
        result = findViewById(R.id.textView)
        diceFace = findViewById(R.id.diceImage)
        tossDice.setOnClickListener {
            Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }



    private fun rollDice() {
        val dice = Dice()
        val diceRoll = dice.roll()
        result.text = diceRoll.toString()
        result.textSize = 34F
        when (diceRoll){
            1 -> diceFace.setImageDrawable(getDrawable(R.drawable.dice_1))
            2 -> diceFace.setImageDrawable(getDrawable(R.drawable.dice_2))
            3 -> diceFace.setImageDrawable(getDrawable(R.drawable.dice_3))
            4 -> diceFace.setImageDrawable(getDrawable(R.drawable.dice_4))
            5 -> diceFace.setImageDrawable(getDrawable(R.drawable.dice_5))
            6 -> diceFace.setImageDrawable(getDrawable(R.drawable.dice_6))
        }
    }
}

class Dice(private val numSides: Int = 6) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}