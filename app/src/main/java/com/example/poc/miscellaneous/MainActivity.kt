package com.example.poc.miscellaneous

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poc.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
        binding.startActivity1.setOnClickListener {
            startActivity(Intent(this, com.example.poc.MainActivity::class.java))
        }
        binding.startActivity2.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}