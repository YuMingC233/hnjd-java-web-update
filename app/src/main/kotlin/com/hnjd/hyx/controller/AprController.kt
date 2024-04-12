package com.hnjd.hyx.controller

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

    @GetMapping("exam_demo")
    fun reqDemo() : String
    {
        return "/0409/exam"
    }

    @PostMapping("req_demo")
    fun reqDemo(
        model : Model,
        @RequestParam("uName") uName : String,
        @RequestParam("uClass") uClass : String,
        @RequestParam("drone") option1 : String,
        @RequestParam("ponp") option2 : String
    ) : String
    {
        var score = 0
        model.addAttribute("uName", uName)
        model.addAttribute("uClass", uClass)

        if (option1 == "yes")
            score += 50
        if (option2 == "no")
            score += 50

        model.addAttribute("uScore", score)
        return "/0409/exam_result"
    }

    @GetMapping("goto")
    fun goto() : String
    {
        return "/0409/goto"
    }

    @PostMapping("goto_sth")
    fun gotoSth(
        model : Model,
        @RequestParam("url") url : String
    ) : String
    {
        return "redirect:$url"
    }

    @GetMapping("login0409")
    fun login0407() : String
    {
        return "/0409/login"
    }

    @PostMapping("login0409-do")
    fun login0409Do(
        model : Model,
        @RequestParam("username") uName : String,
        @RequestParam("password") uPwd : String
    ) : String
    {
        if (uName == "demo" && uPwd == "demo")
            return "/0409/success"
        else
            return "/0409/faild"
    }
}