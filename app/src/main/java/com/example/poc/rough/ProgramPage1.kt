package com.example.poc.rough

//--------------------------------------------------------------------------------------------------
// Sum of two values.
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
// Moves zeros to left.
fun moveZerosToLeft(array: Array<Int>): Array<Int> {
    if (array.size <= 1) {
        return array
    }

    var readPointer = array.size - 1
    var writePointer = array.size - 1
    while (readPointer >= 0) {
        if (array[readPointer] != 0) {
            array[writePointer] = array[readPointer]
            writePointer -= 1
        }

        readPointer -= 1
    }

    while (writePointer >= 0) {
        array[writePointer] = 0
        writePointer--
    }
    return array
}

//--------------------------------------------------------------------------------------------------
// Delete node with given key.
class Node constructor() {
    var key: Int? = null
    var next: Node? = null
    var random: Node? = null

    constructor(key: Int?, next: Node?, random: Node?) : this() {
        this.key = key
        this.next = next
        this.random = random
    }

    companion object {

        fun createRandomPointerLinkedList(): Node {
            val node3 = Node(1, null, null)
            val node2 = Node(2, node3, node3)
            return Node(3, node2, node3)
        }

        fun printRandomPointerLinkedinList(head: Node?) {
            var current = head
            while (current != null) {
                print("$current : K:${current.key} N:${current.next?.key} R:${current.random?.key} -> ")
                current = current.next
            }
        }

        fun createRandomLinkedList(): Node? {
            var head: Node? = null
            var current: Node? = null
            var prev: Node? = null
            for (i in 1..10) {
                current = Node()
                current.key = i
                if (head == null) {
                    head = current
                }
                if (prev == null) {
                    prev = current
                } else {
                    prev.next = current
                    prev = prev.next
                }
            }
            return head
        }

        fun displayLinkedList(head: Node?) {
            var current = head
            while (current != null) {
                print("${current.key} -> ")
                current = current.next
            }
        }

        fun deleteKey(key: Int, head: Node?): Node? {
            if (head == null) {
                return head
            }
            var prev: Node? = null
            var current = head
            while (current != null) {
                if (current.key == key) {
                    return if (prev != null) {
                        prev.next = current.next
                        head
                    } else {
                        current.next
                    }
                } else {
                    prev = current
                    current = current.next
                }
            }
            return head
        }
    }

    fun copyRandomPointerLinkedList(head: Node?): Node? {
        var current = head
        var newHead: Node? = null
        var prev: Node? = null
        var newNode: Node?
        val hashMap = HashMap<Node, Node>()
        while (current != null) {
            newNode = Node()
            newNode.key = current.key
            hashMap[current] = newNode
            if (newHead == null) {
                newHead = newNode
            }
            if (prev == null) {
                prev = newNode
            } else {
                prev.next = newNode
                prev = prev.next
            }
            current = current.next
        }
        current = head
        while (current != null) {
            val newCorr = hashMap[current]
            val newRandCorr = hashMap[current.random]
            newCorr?.random = newRandCorr
            current = current.next
        }
        return newHead
    }
}
//--------------------------------------------------------------------------------------------------