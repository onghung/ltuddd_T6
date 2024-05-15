 package com.example.myapplication.tuan3

 import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.myapplication.R

class T3ListviewMainActivity : AppCompatActivity() {
    var adapter: T3Adapter? = null
    var ls = ArrayList<T3Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t3_listview_main)
        var lv=findViewById<ListView>(R.id.t3listview)
        ls.add(T3Contact("Nguyen Van A","20",R.drawable.android))
        ls.add(T3Contact("Nguyen Van B","26",R.drawable.apple))
        ls.add(T3Contact("Nguyen Van C","21",R.drawable.hp))

        adapter=T3Adapter(ls,this)
        lv!!.adapter=adapter
    }
}