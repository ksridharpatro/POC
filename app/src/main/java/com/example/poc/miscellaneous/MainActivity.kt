package com.example.poc.miscellaneous

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.poc.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
        binding.editText.setDrawableClickListener {
            when (it) {
                CustomEditText.DrawableClickListener.DrawablePosition.RIGHT -> {
                    Log.d("CustomEditText", "right drawable clicked")
                }
                else -> {

                }
            }
        }

        binding.editText.setOnClickListener {
            Log.d("CustomEditText", "edit text clicked")
        }
    }
}