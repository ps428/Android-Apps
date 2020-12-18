package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val diceImage2: ImageView = findViewById(R.id.dice_image2)

        //rollButton.setOnClickListener {rollDice()}
        rollButton.setOnClickListener{rollDice(diceImage, diceImage2 )}

        val clearButton: Button = findViewById(R.id.clear_button)

        clearButton.setOnClickListener{clearAll(diceImage, diceImage2)}
    }

    private fun clearAll(diceImage: ImageView, diceImage2: ImageView){
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }
    private fun rollDice(diceImage: ImageView, diceImage2: ImageView) {//to enhance the code, i have called dice Image as a parameter only instead of calling it for every function call

        var randomInt = (1..6).random()


        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage.setImageResource(drawableResource)

        randomInt = (1..6).random()

        val drawableResource2 = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)

        /*  val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()*/

    /*Toast.makeText(this, "button clicked",
                Toast.LENGTH_SHORT).show()*/
    }

}