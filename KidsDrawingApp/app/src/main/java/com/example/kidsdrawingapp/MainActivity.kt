package com.example.kidsdrawingapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var DrawView:DrawingView?= null
    var undo:ImageButton?=null
    var eraser:ImageButton?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DrawView = findViewById(R.id.drawing_view)
        undo =findViewById<ImageButton>(R.id.undo)
        eraser = findViewById<ImageButton>(R.id.Eraser)
        undo?.setOnClickListener {
        DrawView?.undo()

        }
        eraser?.setOnClickListener {
            DrawView?.selectmarker(Color.WHITE)
        }


    }
}