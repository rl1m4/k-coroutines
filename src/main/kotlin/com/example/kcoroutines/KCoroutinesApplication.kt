package com.example.kcoroutines

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KCoroutinesApplication

fun main(args: Array<String>) {
	runApplication<KCoroutinesApplication>(*args)
}
