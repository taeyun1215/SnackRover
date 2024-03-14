package com.example

import org.springframework.batch.item.ItemReader
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

class RestAreaItemReader : ItemReader<RestAreaItemReader.ApiRestArea> {
    private var restAreaIterator: Iterator<ApiRestArea>? = null

    override fun read(): ApiRestArea? {
        if (restAreaIterator == null) {
            val restTemplate = RestTemplate()
            val response = restTemplate.getForObject<ApiResponse>("https://data.ex.co.kr/openapi/restinfo/hiwaySvarInfoList?key=3560017174&type=json")
            restAreaIterator = response.list.iterator()
        }
        return if (restAreaIterator!!.hasNext()) restAreaIterator!!.next() else null
    }

    data class ApiResponse(val list: List<ApiRestArea>)
    data class ApiRestArea(val svarCd: String, val svarNm: String)
}