package com.hnjd.hyx.Controller

import com.hnjd.hyx.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
class TestController {
    @Autowired
    lateinit var service: TestService

    @GetMapping("/test")
    fun test(model : Model) : String {
        service.test()
        return "Home"
    }
}