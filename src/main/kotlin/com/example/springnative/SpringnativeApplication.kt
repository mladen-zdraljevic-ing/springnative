package com.example.springnative

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringnativeApplication

fun main(args: Array<String>) {
    runApplication<SpringnativeApplication>(*args)
}
