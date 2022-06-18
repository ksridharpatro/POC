package com.example.poc.rough

//--------------------------------------------------------------------------------------------------
// sum of two values.
fun isSumAvailable(array: Array<Int>, sum: Int): Boolean {
    val hashSet: HashSet<Int> = HashSet()
    for (i in array) {
        if (hashSet.contains(sum - i)) {
            return true
        }
        hashSet.add(i)
    }
    return false
}
//--------------------------------------------------------------------------------------------------
// Moves zeros to left
fun moveZerosToLeft(array: Array<Int>): Array<Int> {
    if(array.size <= 1) {
        return array
    }

    var readPointer = array.size - 1
    var writePointer = array.size - 1
    while(readPointer >= 0) {
        if(array[readPointer] != 0) {
            array[writePointer] = array[readPointer]
            writePointer -= 1
        }

        readPointer -= 1
    }

    while(writePointer >= 0) {
        array[writePointer] = 0
        writePointer--
    }
    return array
}
//--------------------------------------------------------------------------------------------------
