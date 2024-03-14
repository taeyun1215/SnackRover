package com.example

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
class BatchApplication {

    @Scheduled(cron = "0 0 3 * * MON") // 매주 월요일 오전 3시에 실행
    fun scheduleTaskUsingCronExpression() {
        // 배치 작업을 여기서 실행
    }

    @Bean
    fun jobBuilderFactory(dataSource: DataSource, transactionManager: PlatformTransactionManager): JobBuilderFactory {
        return JobBuilderFactory(JobRepositoryFactoryBean().also {
            it.setDataSource(dataSource)
            it.setTransactionManager(transactionManager)
            it.setIsolationLevelForCreate("ISOLATION_DEFAULT")
            it.afterPropertiesSet()
        }.`object`!!)
    }

    @Bean
    fun stepBuilderFactory(dataSource: DataSource, transactionManager: PlatformTransactionManager): StepBuilderFactory {
        return StepBuilderFactory(jobBuilderFactory(dataSource, transactionManager).`object`!!, transactionManager)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(BatchApplication::class.java, *args)
        }
    }
}