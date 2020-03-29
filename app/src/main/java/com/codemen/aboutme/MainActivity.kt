package com.codemen .aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        done_botton.setOnClickListener { addNickname(it) }
        namenick_text.setOnClickListener { updateNickname(it) }
    }


    private fun addNickname(it: View) {
         namenick_text.text = name_edit.editableText
         name_edit.visibility = View.GONE
         it.visibility  = View.GONE
         namenick_text.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }

    private fun updateNickname(it: View) {
        name_edit.visibility = View.VISIBLE
        done_botton.visibility = View.VISIBLE
        it.visibility = View.GONE
        name_edit.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(name_edit, 0)
    }

}
