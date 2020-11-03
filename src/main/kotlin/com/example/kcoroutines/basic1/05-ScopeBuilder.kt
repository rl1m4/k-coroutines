package com.example.kcoroutines.basic1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    coroutineScope {
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // This line will be printed before the nested launch
    }

    println("Coroutine scope is over") // This line is not printed until the nested launch completes
}

/*
 1 - It is possible to declares separate scope using `coroutineScope` builder
 2 - It creates a coroutine scope and does not complete until all launched children complete
 3 - `runBlocking` and `coroutineScope` look similar both waiting for their body and its children to complete
 4 - the main difference is that `runBlocking` blocks the current thread for waiting - regular function
 5 - `coroutineScope` just suspends, releasing the underlying thread for other usages - suspending function
 */