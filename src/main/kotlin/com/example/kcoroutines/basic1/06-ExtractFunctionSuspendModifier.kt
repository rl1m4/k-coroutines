package com.example.kcoroutines.basic1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { doWorld() }
    print("Hello, ")
}

// first suspend function
suspend fun doWorld() {
    delay(1000L)
    print("World")
}

/*
 1 - Extract block of code inside launch { ... } into a separate function
 2 - Suspend functions can be used inside coroutines like regular functions
 3 - Theis additional feature is that they can run, in turn, use other suspending functions (like delay) to suspend execution of a coroutine
 4 - What if extracted function contains a coroutine builder which is invoked on the current scope?
 5 - In this  casse, the supend modifier on the extracted function is not enough.
 6 - Making doWorld an extension method on CoroutineScope is one of the solutions
 7 - But may not always be applicable as it does not make the API clearer.
 8 - It is better to have either an explicit CoroutineScope as a field in a class containing the target function
 9 - Or an implicit one when the outer class implements CoroutineScope
 */