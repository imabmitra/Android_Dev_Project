package com.example.counterapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_click=findViewById<Button>(R.id.Button)
        val cnt_text=findViewById<TextView>(R.id.CntDisp)
        var cnt=0
        button_click.setOnClickListener {
            cnt+=1
            cnt_text.text=cnt.toString()
            Toast.makeText(this, "You Pressed Click Button", Toast.LENGTH_SHORT).show()
        }
    }
}