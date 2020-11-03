package com.example.kcoroutines.basic1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(100_000) {// launch a lot of coroutines
        launch {
            delay(5000L)
            println(".")
        }
    }
}

/*
 1 - It launches 100K coroutines and, after 5s, each coroutine prints a dot.
 2 - Try the same with threads: Most likely the code will produce some sort of out-of-memory error
 */