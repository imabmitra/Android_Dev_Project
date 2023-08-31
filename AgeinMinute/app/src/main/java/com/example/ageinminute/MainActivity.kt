package com.example.ageinminute

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.text.Selection
import android.widget.*
import androidx.annotation.Nullable
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var SelectedDate:TextView?=null
    private var CalculatedMin:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val date_picker_button=  findViewById<Button>(R.id.button)
        SelectedDate= findViewById<TextView>(R.id.selectdate)
        CalculatedMin= findViewById<TextView>(R.id.calculatedmin)
        date_picker_button.setOnClickListener {
            ConvertAgeInMin()
        }
    }
    private fun ConvertAgeInMin(){
        val calender = Calendar.getInstance()
        val year=calender.get(Calendar.YEAR)
        val month=calender.get(Calendar.MONTH)
        val dayOfMonth= calender.get((Calendar.DAY_OF_MONTH))
        val dpd=DatePickerDialog(this,{view,year,month,dayofmonth->
             SelectedDate?.text= "${dayofmonth}/${month+1}/${year}"
            val sd=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val TheDate=sd.parse("${dayofmonth}/${month+1}/${year}")
            TheDate?.let {
                val minutes=TheDate.time/60000
                val currentdate=sd.parse(sd.format(System.currentTimeMillis()))
                currentdate?.let{
                    val currentdateinmili=currentdate.time/60000
                    val difference=currentdateinmili-minutes
                    CalculatedMin?.text= difference.toString()


                }


            }

        },year,month,dayOfMonth)
        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000
        dpd.show()
//        Toast.makeText(this, "test texts", Toast.LENGTH_SHORT).show()
    }
}