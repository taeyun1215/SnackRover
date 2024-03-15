package com.example

import com.example.entity.restArea.RestAreaJpaEntity
import com.example.entity.restArea.RestAreaRepository
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter
import org.springframework.lang.NonNull

class RestAreaItemWriter(private val restAreaRepository: RestAreaRepository) : ItemWriter<RestAreaJpaEntity> {

    override fun write(@NonNull chunks: Chunk<out RestAreaJpaEntity>) {
        restAreaRepository.saveAll(chunks.items)
    }
}