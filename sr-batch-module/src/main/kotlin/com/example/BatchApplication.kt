package com.example

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@EnableBatchProcessing
@EntityScan(basePackages = ["com.example.entity"])
@EnableJpaRepositories(basePackages = ["com.example.entity"])
@SpringBootApplication
class BatchApplication
fun main(args: Array<String>) {
    runApplication<BatchApplication>(*args)
}