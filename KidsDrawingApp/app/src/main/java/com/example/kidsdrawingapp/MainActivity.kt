package com.example.kidsdrawingapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var DrawView:DrawingView?= null
    var undo:ImageButton?=null
    var eraser:ImageButton?=null
    var red:TextView?=null
    var black:TextView?=null
    var green:TextView?=null
    var yellow:TextView?=null
    var blue:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DrawView = findViewById(R.id.drawing_view)
        undo =findViewById<ImageButton>(R.id.undo)
        eraser = findViewById<ImageButton>(R.id.Eraser)
        red = findViewById<TextView>(R.id.red)
        black = findViewById<TextView>(R.id.black)
        green = findViewById<TextView>(R.id.green)
        yellow = findViewById<TextView>(R.id.yellow)
        blue = findViewById<TextView>(R.id.blue)
        undo?.setOnClickListener {
            DrawView?.undo()

        }
        eraser?.setOnClickListener {
            DrawView?.selectmarker(Color.WHITE)
        }
        red?.setOnClickListener {
            DrawView?.selectmarker(Color.RED)
        }
        black?.setOnClickListener {
            DrawView?.selectmarker(Color.BLACK)
        }
        green?.setOnClickListener {
            DrawView?.selectmarker(Color.GREEN)
        }
        yellow?.setOnClickListener {
            DrawView?.selectmarker(Color.YELLOW)
        }
        blue?.setOnClickListener {
            DrawView?.selectmarker(Color.CYAN)
        }
    }
}