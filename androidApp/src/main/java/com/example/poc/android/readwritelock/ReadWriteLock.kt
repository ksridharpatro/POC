package com.example.poc.android.readwritelock

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class ReadWriteLock {
    private val writeLock = Mutex()
    private val readerCountLock = Mutex()

    private var readerCount = 0

    suspend fun <T> invokeUsingReadLock(codeBlock: suspend () -> T): T {
        return try {
            readerCountLock.withLock {
                if (readerCount++ == 0) {
                    writeLock.lock(this)
                }
            }

            codeBlock()
        } finally {
            readerCountLock.withLock {
                if (--readerCount == 0) {
                    writeLock.unlock(this)
                }
            }
        }
    }

    suspend fun <T> invokeUsingWriteLock(codeBlock: suspend () -> T): T {
        return writeLock.withLock {
            readerCountLock.withLock {
                codeBlock()
            }
        }
    }
}