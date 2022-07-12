package com.example.poc.programs

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun stream() = flow {
    emit("Flow 🌊") // Emits the value upstream☝
}

fun main() = runBlocking {
    stream().collect { value ->
        println(value)
    }
}


















