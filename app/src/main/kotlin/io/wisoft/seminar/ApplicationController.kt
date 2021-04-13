package io.wisoft.seminar

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ApplicationController {

    @GetMapping
    fun getIndex(): String = "Welcome! Wisoft Laboratory."

}
