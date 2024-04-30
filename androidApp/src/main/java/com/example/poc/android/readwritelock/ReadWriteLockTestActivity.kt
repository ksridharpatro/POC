package com.example.poc.android.readwritelock

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import com.example.poc.android.MyApplicationTheme

class ReadWriteLockTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Text(text = "Hello")
            }
        }
        val filePath = applicationContext.getDatabasePath("dbFileName").path
        val afilePath = applicationContext.getDatabasePath("dbFileName").absolutePath
        Log.d("ReadWriteLockActivity", filePath)
        Log.d("ReadWriteLockActivity", afilePath)
    }
}