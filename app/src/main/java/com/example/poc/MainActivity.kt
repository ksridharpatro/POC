package com.example.poc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.poc.miscellaneous.SingleTonExample

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("SingletopnExample", "address - " + SingleTonExample.getInstance().toString())
        Log.d("SingletopnExample", "class loader - " + SingleTonExample::class.java.classLoader)
    }
}