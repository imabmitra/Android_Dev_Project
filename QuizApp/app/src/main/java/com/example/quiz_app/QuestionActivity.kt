package com.example.quiz_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {
    var quiz:TextView?=null
    var flag:ImageView?=null
    var option1:TextView?=null
    var option2:TextView?=null
    var option3:TextView?=null
    var option4:TextView?=null
    var submit:Button?=null
    var progress_bar:ProgressBar?=null
    var progress_text:TextView?=null
    var num_correct_ans=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        quiz=findViewById(R.id.quiz)
        flag=findViewById(R.id.flag)
        option1=findViewById(R.id.op1)
        option2=findViewById(R.id.op2)
        option3=findViewById(R.id.op3)
        option4=findViewById(R.id.op4)
        submit=findViewById(R.id.btn_submit)
        progress_bar=findViewById(R.id.prog_bar)
        progress_text=findViewById(R.id.prog_text)
//        Log.v("Number of Question", Constants.getQuestion()[0].optionOne)
        set_question(0)
    }
    private fun set_question(i:Int){
        var submitflag=false
        var qno=i
        val quiz_array=Constants.getQuestion()
        val correct_answer= quiz_array[i].correctAnswer
        var selectedAnswer =0
        var selectedop:TextView?=null
        quiz?.text=quiz_array[i].question
        flag?.setImageResource(quiz_array[i].image)
        option1?.text=quiz_array[i].optionOne
        option2?.text=quiz_array[i].optionTwo
        option3?.text=quiz_array[i].optionThree
        option4?.text=quiz_array[i].optionFour
        progress_bar?.progress=qno+1
        progress_text?.text= "${qno+1}/${quiz_array.size}"

        var correct_option:TextView?=null
        if(correct_answer==1) correct_option=option1
        else if(correct_answer==2) correct_option=option2
        else if(correct_answer==3) correct_option=option3
        else if(correct_answer==4) correct_option=option4

        option1?.setOnClickListener {
            if(submitflag==false) {
                selectedAnswer=1
                selectedop?.setBackgroundResource(R.drawable.option_background)
                selectedop?.setTextColor(Color.parseColor("#7A8089"))
                selectedop = option1
                selectedop?.setBackgroundColor(Color.parseColor("#B642F5"))
                selectedop?.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
        option2?.setOnClickListener {
            if(submitflag==false) {
                selectedAnswer = 2
                selectedop?.setBackgroundResource(R.drawable.option_background)
                selectedop?.setTextColor(Color.parseColor("#7A8089"))
                selectedop = option2
                selectedop?.setBackgroundColor(Color.parseColor("#B642F5"))
                selectedop?.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
        option3?.setOnClickListener {
            if(submitflag==false) {
                selectedAnswer = 3
                selectedop?.setBackgroundResource(R.drawable.option_background)
                selectedop?.setTextColor(Color.parseColor("#7A8089"))
                selectedop = option3
                selectedop?.setBackgroundColor(Color.parseColor("#B642F5"))
                selectedop?.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
        option4?.setOnClickListener {
            if(submitflag==false) {
                selectedAnswer = 4
                selectedop?.setBackgroundResource(R.drawable.option_background)
                selectedop?.setTextColor(Color.parseColor("#7A8089"))
                selectedop = option4
                selectedop?.setBackgroundColor(Color.parseColor("#B642F5"))
                selectedop?.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
        qno += 1
        submit?.setOnClickListener {
            if((qno<quiz_array.size) and (submitflag)) {
                selectedop?.setBackgroundResource(R.drawable.option_background)
                selectedop?.setTextColor(Color.parseColor("#7A8089"))
                correct_option?.setBackgroundResource(R.drawable.option_background)
                correct_option?.setTextColor(Color.parseColor("#7A8089"))
                submit?.text="Check Answer"
                set_question(qno)
            }
            else if (submitflag==false){
                if(qno<quiz_array.size){
                submit?.text="Submit"
                }
                else{
                submit?.text="Finish"
                }
                correct_option?.setBackgroundColor(Color.parseColor("#0F9D58"))
                correct_option?.setTextColor(Color.parseColor("#FFFFFF"))

                if (correct_answer != selectedAnswer) {
                    selectedop?.setBackgroundColor(Color.parseColor("#FF0000"))
                    selectedop?.setTextColor(Color.parseColor("#FFFFFF"))
                }
                else if(correct_answer == selectedAnswer){
                    num_correct_ans+=1
                }

                if(qno==quiz_array.size){
//                    Log.v("Correct Answer","${num_correct_ans}")
                    val intant =Intent(this,ResultActivity::class.java)
                    startActivity((intant))
                    finish()
                }

            }
            submitflag=true
            }

    }
}