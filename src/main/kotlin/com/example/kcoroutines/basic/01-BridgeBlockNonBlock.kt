package com.example.kcoroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch { // launch coroutine in background and continue
        delay(1000L) // non-blocking delay for 1s
        print("World!")
    }

    print("Hello, ") // main thread continues here immediately
    runBlocking {  // it blocks the main thread
        delay(2000L) // while delay for 2s to keep JVM alive
    }
}

/*
 1 - Being explicit about blocking using `runBlocking` coroutine builder
 2 - runs a non-blocking `delay`
 3 - the main thread invoking ``runBlocking blocks until the coroutine inside `runBlocking` completes
 */