package com.example.poc.android.readwritelock

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import com.example.poc.android.MyApplicationTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ReadWriteLockTestActivity : AppCompatActivity() {

    val readWriteLock: ReadWriteLock = ReadWriteLock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Text(text = "Hello")
            }
        }

        GlobalScope.launch {

            readWriteLock.invokeUsingWriteLock {
                Log.d("ReadWriteLockTest", "Write started")
                delay(5000)
                Log.d("ReadWriteLockTest", "Write completed")
            }
        }
        GlobalScope.launch {
            delay(2000)
            readWriteLock.invokeUsingReadLock {
                Log.d("ReadWriteLockTest", "Read started")
                delay(5000)
                Log.d("ReadWriteLockTest", "Read completed")
            }
        }
    }
}