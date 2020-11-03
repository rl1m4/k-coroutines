package com.example.kcoroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = GlobalScope.launch {// launch new coroutine and keep a reference to its job
        delay(10000L) // non-blocking
        print("World")
    }

    print("Hello, ") // main thread
    job.join() //wait until child coroutine completes
}

/*
 1 - Delaying for a time while another coroutine is working is not a good approach.
 2 - Better to explicitly wait in a non-blocking way until the background job is completed
 3 - This code still the same, but the code of the main coroutine is not tied to the duration of the background job - better
 */