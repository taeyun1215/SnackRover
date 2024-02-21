package com.example.demo.foodTruck.adapter.inbound.web

import com.example.demo.foodTruck.adapter.inbound.payload.CreateFoodTruckRequest
import com.example.demo.foodTruck.adapter.inbound.payload.CreateFoodTruckResponse
import com.example.demo.foodTruck.usecase.inbound.command.CreateFoodTruckCommand
import com.example.demo.foodTruck.usecase.inbound.service.CreateFoodTruckService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/foodtrucks")
class CreateFoodTruckController(private val createFoodTruckService: CreateFoodTruckService) {

    @PostMapping
    fun createFoodTruck(@RequestBody request: CreateFoodTruckRequest): ResponseEntity<CreateFoodTruckResponse> {
        val createFoodTruckCommand = CreateFoodTruckCommand(
            name = request.name,
            foodType = request.foodType
        )

        createFoodTruckService.createFoodTruck(createFoodTruckCommand)
        return ResponseEntity.ok(CreateFoodTruckResponse("푸드트럭이 등록되었습니다."))
    }
}