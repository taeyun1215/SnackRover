package com.example

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.*

@Configuration
@EnableScheduling
class BatchSchedulerConfig(
    private val jobLauncher: JobLauncher,
    private val importJob: Job
) {
    @Scheduled(cron = "0 0 3 * * MON")
    fun runBatchJob() {
        val jobParameters = JobParametersBuilder()
            .addDate("date", Date())
            .toJobParameters()
        jobLauncher.run(importJob, jobParameters)
    }
}