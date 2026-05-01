package com.example.doom

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import android.widget.ActionMenuView
import android.widget.LinearLayout

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val textView = TextView(this).apply {
            text = "Hello from Doom"
            textSize = 24f
        }

        val actionMenuView = ActionMenuView(this)
        val menu = actionMenuView.menu
        menu.add("hello")
        menu.add("hello")
        menu.add("hello")
        menu.add("hello")

        layout.addView(textView)
        layout.addView(actionMenuView)

        setContentView(layout)
    }
}
