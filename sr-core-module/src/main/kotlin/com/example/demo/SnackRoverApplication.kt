package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@EntityScan(basePackages = ["com.example.entity"])
@EnableJpaRepositories(basePackages = ["com.example.entity"])
@SpringBootApplication(scanBasePackages = ["com.example"])
class SnackRoverApplication

fun main(args: Array<String>) {
	runApplication<SnackRoverApplication>(*args)
}
