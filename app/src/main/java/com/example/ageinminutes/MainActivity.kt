package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

        var tvSelectDate:TextView?=null
        var  tvAgeInMinutes:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker:Button= findViewById(R.id.btnDatePicker)
            tvSelectDate=findViewById(R.id.tvSelectedDate)
            tvAgeInMinutes=findViewById(R.id.tvAgeInMinutes)
        btnDatePicker.setOnClickListener {
            clickDatePicker()

        }
    }
    private fun clickDatePicker(){
        val myCalender=Calendar.getInstance()
        val year=myCalender.get(Calendar.YEAR)
        val month=myCalender.get(Calendar.MONTH)
        val day=myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
        {view, SelectedYear,SelectedMonth,SelectedDayOfMonth->


            val SelectedDate="$SelectedDayOfMonth/${SelectedMonth+1}/ $SelectedYear"
            Toast.makeText(this,"$SelectedDate",Toast.LENGTH_SHORT).show()
            tvSelectDate?.setText(SelectedDate)

            val sdf= SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

            val theDate=sdf.parse(SelectedDate)

            val SelectedDateInMinutes = theDate.time/60000

            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes=currentDate.time/60000

            val differenceInMinutes = currentDateInMinutes-SelectedDateInMinutes

            tvAgeInMinutes?.text=differenceInMinutes.toString()
        },
            year,
            month,
            day
        ).show()


    }
}