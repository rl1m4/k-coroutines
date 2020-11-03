package com.example.kcoroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // start main coroutine
    GlobalScope.launch { // launch new coroutine in background and continue
        delay(1000L) // non-blocking
        print("World")
    }

    print("Hello, ") // main coroutine continues here imemediately
    delay(2000L) // delay for 2s to keep JVM alive
}

/*
 1 - using `runBlocking` to wrap the execution of the main function
 2 - `runBlocking` works as an adaptor that is used to start the top-lvel main coroutine
 3 - this is also a way to write unit tests for suspending functions `fun name() = runBlocking { ... }`
 */