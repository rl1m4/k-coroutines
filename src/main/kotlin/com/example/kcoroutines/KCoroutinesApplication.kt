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
