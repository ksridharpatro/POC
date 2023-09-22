package com.example.poc.android.kmmpoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.poc.Greeting
import com.example.poc.android.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var phrases by remember { mutableStateOf(listOf("Loading")) }
                    LaunchedEffect(true) {
                        phrases = try {
                            Greeting().greet()
                        } catch (e: Exception) {
                            listOf(e.localizedMessage ?: "error")
                        }
                    }
                    GreetingView(phrases)
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: List<String>) {
    Text(text = text.joinToString(separator = "\n"))
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView(listOf("Hello, Android!", "asdasd"))
    }
}
