package com.example.kotlinlangplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.kotlinlangplayground.logic.FlipFlopLogic
import kotlinx.android.synthetic.main.activity_field_seven_to_seven.*


class FieldSevenToSeven : AppCompatActivity() {
    val logic = FlipFlopLogic()
    val state: Array<BooleanArray> = Array(7, { BooleanArray(7, { false }) })
    lateinit var btnMatrix: Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_field_seven_to_seven)

        logic.state = state
        logic.width = 7
        logic.height = 7

//        btnMatrix = Array(7, {i-> Array(7, {j-> findViewById<Button>((R.id.btn)+j)}) })

        btnMatrix = arrayOf(
            arrayOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7),
            arrayOf(btn8, btn9, btn10, btn11, btn12, btn13, btn14),
            arrayOf(btn15, btn16, btn17, btn18, btn19, btn20, btn21),
            arrayOf(btn22, btn23, btn24, btn25, btn26, btn27, btn28),
            arrayOf(btn29, btn30, btn31, btn32, btn33, btn34, btn35),
            arrayOf(btn36, btn37, btn38, btn39, btn40, btn41, btn42),
            arrayOf(btn43, btn44, btn45, btn46, btn47, btn48, btn49)
        )

        for (xx: Int in 0..6) {
            for (yy: Int in 0..6) {
                btnMatrix[yy][xx].setOnClickListener { v -> onButtonClick(xx, yy) }
            }
        }
        buttonRevert.setOnClickListener{finish()}
        logic.shuffle()
        updateButtons()
    }

    private fun updateButtons() {
        for (xx: Int in 0..6) {
            for (yy: Int in 0..6) {

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