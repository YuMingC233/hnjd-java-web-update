package com.hnjd.hyx.Controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AprController {
    @GetMapping("prismatic")
    fun prismatic(model: Model) : String
    {
        model.addAttribute("size", 7)
        return "/0407/prismatic"
    }

    @GetMapping("multable")
    fun multable(model: Model) : String
    {
        return "/0407/multable"
    }

    @GetMapping("/calc")
    fun calc(model : Model) : String
    {
        return "/0407/calc"
    }

    @PostMapping("/getCalcResult")
    fun calcResult(
        model : Model,
       @RequestParam("num1") num1 : String,
       @RequestParam("num2") num2 : String,
       @RequestParam("operator") operator : String
    ) : String
    {
        // kotlin增强版switch
        when(operator) {
            "+" -> model.addAttribute("resultNum", num1.toInt() + num2.toInt())
            "-" -> model.addAttribute("resultNum", num1.toInt() - num2.toInt())
            "*" -> model.addAttribute("resultNum", num1.toInt() * num2.toInt())
            "/" -> model.addAttribute("resultNum", num1.toInt() / num2.toInt())
        }
        model.addAttribute("num1", num1)
        model.addAttribute("num2", num2)
        return "/0407/calc"
    }
}