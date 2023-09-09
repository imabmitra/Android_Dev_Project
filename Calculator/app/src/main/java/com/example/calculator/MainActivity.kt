package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var textviewinput:TextView?= null
    var islastint:Boolean?=false
    var expcnt:Int=0
    var decicnt:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textviewinput= findViewById<TextView>(R.id.display)
    }
    fun ondigit(view: View) {
        if ((textviewinput?.text?.toString()=="0") or (textviewinput?.text?.toString()=="Infinite")){
            textviewinput?.text=(view as Button).text
            islastint = true
        }
        else{
        textviewinput?.append((view as Button).text)
        islastint = true
        }
    }

    fun onclear(view: View) {
        textviewinput?.text="0"
        islastint = false
        expcnt=0
        decicnt=0
    }

    fun onexpression(view: View){
        if((textviewinput?.text?.toString()=="0") and ((view as Button).text=="-") ){
            textviewinput?.text=((view as Button).text)
            islastint =false
            decicnt=0
        }
        else if((islastint == true) and  (expcnt==0)  ){
            textviewinput?.append((view as Button).text)
            islastint =false
            expcnt+=1
            decicnt=0
        }


    }

    fun ondecimal(view: View) {
        if((textviewinput?.text?.toString()=="0")){
            textviewinput?.text="0."
            islastint =false
            decicnt+=1
        }
        if ((islastint == true) and (decicnt == 0)) {
            textviewinput?.append((view as Button).text)
            islastint = false
            decicnt += 1
        }
    }

    fun oncalculate(view: View) {

        if (islastint == true) {
            var prefix: String = ""
            var equation = textviewinput?.text.toString()
            if (equation.startsWith("-")) {
                prefix = "-"
                equation = equation.substring(1)
            }
            if (equation.contains("-")) {
                val splitval = equation.split("-")
                var one = splitval[0]
                val two = splitval[1]
                if (!prefix.isEmpty()) {
                    one = prefix + one
                }

                textviewinput?.text =
                    removetrailingzero((one.toDouble() - two.toDouble()).toString())
            }

            if (equation.contains("+")) {
                val splitval = equation.split("+")
                var one = splitval[0]
                val two = splitval[1]
                if (!prefix.isEmpty()) {
                    one = prefix + one
                }

                textviewinput?.text =
                    removetrailingzero((one.toDouble() + two.toDouble()).toString())
            }

            if (equation.contains("*")) {
                val splitval = equation.split("*")
                var one = splitval[0]
                val two = splitval[1]
                if (!prefix.isEmpty()) {
                    one = prefix + one
                }

                textviewinput?.text =
                    removetrailingzero((one.toDouble() * two.toDouble()).toString())
            }

            if (equation.contains("/")) {
                val splitval = equation.split("/")
                var one = splitval[0]
                val two = splitval[1]
                if (!prefix.isEmpty()) {
                    one = prefix + one
                }
                if (two != "0") {

                    textviewinput?.text =
                        removetrailingzero((one.toDouble() / two.toDouble()).toString())
                } else {
                    islastint = false
                    textviewinput?.text = "Infinite"
                }


            }

            islastint = true
            expcnt = 0
        }
    }
    private fun removetrailingzero(result:String):String{
        var value=result
        if (value.endsWith(".0")){
            value = value.substring(0, value.length - 2)
        }
        return value
    }

}