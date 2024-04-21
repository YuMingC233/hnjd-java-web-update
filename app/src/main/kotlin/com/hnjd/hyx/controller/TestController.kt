package com.hnjd.hyx.controller

import com.hnjd.hyx.user.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

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