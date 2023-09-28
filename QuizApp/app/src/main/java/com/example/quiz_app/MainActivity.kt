package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonstart= findViewById<Button>(R.id.btn_start)
        val etname= findViewById<AppCompatEditText>(R.id.et_name)
        buttonstart.setOnClickListener {
            if (etname.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()

            }
            else{
                val intent=Intent(this, QuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}