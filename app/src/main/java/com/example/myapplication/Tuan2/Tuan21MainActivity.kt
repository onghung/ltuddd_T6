package com.example.myapplication.Tuan2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class Tuan21MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan2_main)
        var txt1=findViewById<EditText>(R.id.Tuan2txt1)
        var txt2=findViewById<EditText>(R.id.Tuan2txt2)
        var btn1=findViewById<Button>(R.id.Tuan2btn1)

        btn1!!.setOnClickListener{
            var i = Intent( this@Tuan21MainActivity, Tuan2MainActivityResult::class.java)
            i.putExtra("so1", txt1!!.text.toString())
            i.putExtra("so2", txt2!!.text.toString())
            startActivity(i)
        }
    }
}