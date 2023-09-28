package com.example.poc.kmmpoc

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform