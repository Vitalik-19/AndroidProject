package com.example.kotlinlangplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kotlinlangplayground.logic.FlipFlopLogic
import kotlinx.android.synthetic.main.activity_field_trie_to_trie.*


class FieldTrieToTrie : AppCompatActivity() {

    val logic = FlipFlopLogic()
    val state: Array<BooleanArray> = Array(3, {BooleanArray(3, {false})})
    lateinit var btnMatrix: Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_field_trie_to_trie)

        logic.state = state
        logic.width = 3
        logic.height = 3

        btnMatrix = arrayOf(
            arrayOf(btn1, btn2, btn3),
            arrayOf(btn4, btn5, btn6),
            arrayOf(btn7, btn8, btn9)
        )

        for (xx: Int in 0..2) {
            for (yy: Int in 0..2) {
                btnMatrix[yy][xx].setOnClickListener { v -> onButtonClick(xx, yy) }
            }
        }
        buttonRevert.setOnClickListener{finish()}
        logic.shuffle()
        updateButtons()
    }
    private fun updateButtons() {
        for (xx: Int in 0..2) {
            for (yy: Int in 0..2) {

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
