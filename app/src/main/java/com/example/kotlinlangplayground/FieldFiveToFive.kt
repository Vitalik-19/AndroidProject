package com.example.kotlinlangplayground

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.kotlinlangplayground.logic.FlipFlopLogic
import kotlinx.android.synthetic.main.activity_field_five_to_five.*
class FieldFiveToFive : AppCompatActivity() {

    val logic = FlipFlopLogic()
    val state: Array<BooleanArray> = Array(5, {BooleanArray(5, {false})})
    lateinit var btnMatrix: Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_field_five_to_five)

        logic.state = state
        logic.width = 5
        logic.height = 5

        btnMatrix = arrayOf(
            arrayOf(btn1, btn2, btn3, btn4,btn5),
            arrayOf(btn6, btn7, btn8, btn9, btn10),
            arrayOf(btn11, btn12, btn13, btn14, btn15),
            arrayOf(btn16, btn17, btn18, btn19, btn20),
            arrayOf(btn21, btn22, btn23, btn24, btn25)
        )
        for (xx: Int in 0..4) {
            for (yy: Int in 0..4) {
                btnMatrix[yy][xx].setOnClickListener { v -> onButtonClick(xx, yy) }
            }
        }
        buttonRevert.setOnClickListener{finish()}
        logic.shuffle()
        updateButtons()
    }

    private fun updateButtons() {
        for (xx: Int in 0..4) {
            for (yy: Int in 0..4) {

//                btnMatrix[yy][xx].isEnabled = logic.isChecked(xx, yy) // FIXME: doesn't work as you will not be able to click on disabled button (so stuppid!)

                if (logic.isChecked(xx, yy)) btnMatrix[yy][xx].isActivated = true else btnMatrix[yy][xx].isActivated = false
                btnMatrix[yy][xx].text = if (logic.isChecked(xx, yy)) "☺" else "☻"
            }
        }
    }

    private fun onButtonClick(x: Int, y: Int) {
        logic.action(x, y)
        updateButtons()
        if (logic.haveWon())
            Toast.makeText(this, "Have won!", Toast.LENGTH_SHORT).show()
    }

}
