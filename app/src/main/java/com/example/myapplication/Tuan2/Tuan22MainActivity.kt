package com.example.myapplication.Tuan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myapplication.R

class Tuan22MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan22_main)
        var lv1=findViewById<ListView>(R.id.tuan22lv1)
        var arr= arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
        val adapter1=ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)
        lv1!!.adapter=adapter1
    }
}