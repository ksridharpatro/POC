package com.example.poc.android.navigationpoc

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import com.example.poc.android.MyApplicationTheme

class Activity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Button(onClick = {
                        startActivity(Intent(this, Activity1::class.java).apply {
                            addFlags(FLAG_ACTIVITY_CLEAR_TOP)
                        })
                        startActivity(Intent(this, Activity2::class.java))
                    }) {
                        Text(text = "Activity4")
                    }
                }
            }
        }
    }
}
