package com.example.kcoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KCoroutinesApplication

fun main() {
	GlobalScope.launch { // launch a new coroutine in background and continue
		delay(1000L) // non-blocking delay for 1 second (1ms -> 1s)
		print("World") // print after delay
	}

	print("Hello, ") // main thread continues while coroutine is delayed
	Thread.sleep(2000L) // block main thread for 2s to keep JVM alive
}

/*
 1 - Coroutines are launched with `launch` coroutine builder in a context of some `CoroutineScope`
 2 - GlobalScope.launch { ... } -> thread { ... }, and delay(...) -> Thread.sleep(...)
 3 - delay is a special suspending function: does not block a thread, it suspends the coroutine
 4 - calling thread { delay() } instead of launch { delay() } -> compiler error because thread it is not suspend function
 5 - calling thread it requires then Threads.sleep(...) instead
 6 - this example mixed non-blocking delay(...) and blocking Thread.sleep(...) in the same code.
 It is easy to lose track of which one is blocking and which one is not.
 */
