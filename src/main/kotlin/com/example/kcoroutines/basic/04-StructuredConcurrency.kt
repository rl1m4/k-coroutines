package com.example.kcoroutines.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // coroutineScope - a main function that is turned into a coroutine
    launch { // new coroutine in the scope of runBlocking
        delay(1000L)
        print("World")
    }

    print("Hello, ")
}

/*
 1 - GlobalScope.launch is a top level coroutine, light-weight but still consumes memory resource while it runs
 2 - If we forget to keep a reference to the newly launched coroutine, it still runs
 3 - What if the code in the coroutine hangs (for example, we erroneously delay for too long)?
 4 - If we launch too many coroutines and ran out of memory?
 5 - Manually keep references to all the launched coroutines and join is an error-prone
 6 - To solve, we can use structured concurrency
 7 - Instead of launching coroutines in the GlobalScope (like threads do)
 8 - We launch in the specific scope of the operation we are performing
 9 - `runBlocking` coroutine builder and every coroutine builder adds an instance of CoroutineScope to the scope of its code block
 10 - We  can launch coroutines in the scope without having to join them explicitly
 11 - an outer coroutine `runBlocking` does not complete until all the coroutines launched in its scope complete
 12 - the code is simpler
 */