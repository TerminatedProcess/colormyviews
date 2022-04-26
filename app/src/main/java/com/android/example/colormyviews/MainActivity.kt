package com.android.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private val boxOneText by lazy { findViewById<TextView>(R.id.box_one_text) }
    private val boxTwoText by lazy { findViewById<TextView>(R.id.box_two_text) }
    private val boxThreeText by lazy { findViewById<TextView>(R.id.box_three_text) }
    private val boxFourText by lazy { findViewById<TextView>(R.id.box_four_text) }
    private val boxFiveText by lazy { findViewById<TextView>(R.id.box_five_text) }
    private val redButton by lazy { findViewById<Button>(R.id.red_button) }
    private val greenButton by lazy { findViewById<Button>(R.id.green_button) }
    private val yellowButton by lazy { findViewById<Button>(R.id.yellow_button) }

    private fun makeColored(view: View) {

        when (view.id) {
            // Boxes using Color class colors for the background
            R.id.box_one_text   -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text   -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text  -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text  -> view.setBackgroundColor(Color.BLUE)
            R.id.red_button     -> boxThreeText.setBackgroundColor(ContextCompat.getColor(this, R.color.my_red))
            R.id.yellow_button  -> boxFourText.setBackgroundColor(ContextCompat.getColor(this, R.color.my_yellow))
            R.id.green_button   -> boxFiveText.setBackgroundColor(ContextCompat.getColor(this, R.color.my_green))
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        // define a list of clickable views
        val clickableViews: List<View> = listOf(
                  boxOneText
                , boxTwoText
                , boxThreeText
                , boxFourText
                , boxFiveText
                , rootConstraintLayout
                , redButton
                , greenButton
                , yellowButton
        )

        for (item in clickableViews)
            item.setOnClickListener { makeColored(it) }
    }

}