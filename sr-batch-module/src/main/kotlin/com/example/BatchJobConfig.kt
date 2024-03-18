package com.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.example.entity.restArea.RestAreaJpaEntity
import com.example.entity.restArea.RestAreaRepository
import com.sun.org.apache.xerces.internal.impl.xpath.XPath
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.boot.autoconfigure.batch.BatchProperties

@Configuration
@EnableBatchProcessing
class BatchJobConfig(
    private val jobLauncher: JobLauncher,
    private val jobRepository: JobRepository,
    private val restAreaRepository: RestAreaRepository
) {
    @Bean
    fun restAreaJob(): BatchProperties.Job {
        val restAreaStep = restAreaStep()
        return JobBuilder("restAreaJob", jobRepository)
            .start(restAreaStep)
            .build()
    }

    @Bean
    fun restAreaStep(): XPath.Step {
        return StepBuilder("restAreaStep", jobRepository)
            .chunk<RestAreaItemReader.ApiRestArea, RestAreaJpaEntity>(10, jobRepository)
            .reader(restAreaReader())
            .processor(restAreaProcessor())
            .writer(restAreaWriter())
            .build()
    }

    @Bean
    fun restAreaReader(): ItemReader<RestAreaItemReader.ApiRestArea> = RestAreaItemReader()

    @Bean
    fun restAreaProcessor(): ItemProcessor<RestAreaItemReader.ApiRestArea, RestAreaJpaEntity> = RestAreaItemProcessor()

    @Bean
    fun restAreaWriter(): ItemWriter<RestAreaJpaEntity> = RestAreaItemWriter(restAreaRepository)
}
