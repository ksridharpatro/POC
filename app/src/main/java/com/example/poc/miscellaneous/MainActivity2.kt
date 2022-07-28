package com.example.poc.miscellaneous

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.poc.R
import com.example.poc.databinding.ActivityMain3Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
        Log.d("SingletopnExample", "address - " + SingleTonExample.getInstance().toString())
        Log.d("SingletopnExample", "class loader - " + SingleTonExample::class.java.classLoader)
    }
}