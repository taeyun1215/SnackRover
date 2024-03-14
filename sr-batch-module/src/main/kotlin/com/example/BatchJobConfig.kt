package com.example

import com.example.entity.restArea.RestAreaJpaEntity
import com.example.entity.restArea.RestAreaRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class BatchJobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val restAreaRepository: RestAreaRepository
) {
    @Bean
    fun restAreaJob(): Job {
        return jobBuilderFactory.get("restAreaJob")
            .incrementer(RunIdIncrementer())
            .start(restAreaStep())
            .build()
    }

    @Bean
    fun restAreaStep(): Step {
        return stepBuilderFactory.get("restAreaStep")
            .chunk<RestAreaItemReader.ApiRestArea, RestAreaJpaEntity>(10)
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
