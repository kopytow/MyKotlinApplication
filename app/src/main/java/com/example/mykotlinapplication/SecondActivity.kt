package com.example.mykotlinapplication

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        if (null != intent) {
            val str = intent.getStringExtra("KEY_STRING")
            if (str != null) {
                val textView = findViewById<TextView>(R.id.text_view)
                textView.text = str
            }
        }
    }
}
