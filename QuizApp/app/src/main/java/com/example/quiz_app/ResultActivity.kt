package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val greet=findViewById<TextView>(R.id.username)
        var score=findViewById<TextView>(R.id.score)
        val username="Hello ${intent.getStringExtra(Constants.USERNAME)}!"
        val correct_ans=intent.getIntExtra(Constants.CORRECT_ANS,0)
        val total_quiz=intent.getIntExtra(Constants.TOTAL_QUIZ,0)
        greet.text= username
        val final_score="${correct_ans}/${total_quiz}"
        score.text=final_score




    }
}