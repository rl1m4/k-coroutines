package com.example.kcoroutines.basic2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    GlobalScope.launch {// launches a long-running coroutine in GlobalScope
        repeat(1000) { it ->
            println("Im sleeping $it ...") // prints "I'm sleeping" twice a second and then returns from the main function after some delay
            delay(500L)
        }
    }

    delay(1300L) // just quit after delay
}

/*
 1- Active coroutines that were launched in GlobalScope do not keep the process alive. They are like daemon threads.
 */