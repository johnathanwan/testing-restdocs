package com.example.testingrestdocs

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class HomeController {
    
    @GetMapping("/")
    fun greeting(): Map<String, Any> = Collections.singletonMap("message", "Hello, World")
}