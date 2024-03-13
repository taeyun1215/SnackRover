package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class SnackRoverApplication

fun main(args: Array<String>) {
	runApplication<SnackRoverApplication>(*args)
}
