package com.example

import com.example.entity.restArea.RestAreaJpaEntity
import org.springframework.batch.item.ItemProcessor

class RestAreaItemProcessor : ItemProcessor<RestAreaItemReader.ApiRestArea, RestAreaJpaEntity> {
    override fun process(item: RestAreaItemReader.ApiRestArea): RestAreaJpaEntity? {
        return RestAreaJpaEntity(
            restAreaCode = item.svarCd.toLong(),
            restAreaName = item.svarNm
        )
    }
}