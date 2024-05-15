package com.example.myapplication.Tuan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R

class Tuan2MainActivityResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan2_main_result)
        var kq = findViewById<TextView>(R.id.Tuan2kq)
        val i1=intent
        val chuoi1 = i1.extras!!.getString("so1")
        val so1= chuoi1!!.toFloat()

        val chuoi2 = i1.extras!!.getString("so2")
        val so2 = chuoi2!!.toFloat()

        val tong = so1+so2

        kq!!.text = tong.toString()

    }
}