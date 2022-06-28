package com.example.poc.programs

fun main() {

    val dictionary: MutableSet<String> = HashSet()
    var s = String()
    s = "hellohellonhellohellon"

    dictionary.add("hello")
    dictionary.add("hell")
    dictionary.add("on")
    dictionary.add("now")
    if (canSegmentString(s, dictionary)) {
        println("String Can be Segmented")
    } else {
        println("String Can NOT be Segmented")
    }
}

fun canSegmentString(s: String?, dictionary: Set<String>): Boolean {
    println(s)

    if (s.isNullOrEmpty() || dictionary.contains(s)) {
        return true
    }

    var first: String?
    var second: String?
    for (i in 1..s.length) {
        first = s.substring(0, i)
        if (dictionary.contains(first)) {
            second = s.substring(i)
            if (canSegmentString(second, dictionary)) {
                return true
            } else {
                continue
            }
        }
    }
    return false
}

















