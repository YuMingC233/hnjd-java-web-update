package com.hnjd.hyx.controller

import com.hnjd.hyx.user.pojo.vo.registerUserDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import com.hnjd.hyx.user.service.IUserService
import org.springframework.web.bind.annotation.RequestBody

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

    @GetMapping("register0409")
    fun register0409() : String
    {
        return "/0409/register"
    }

    @Autowired
    var userService : IUserService? = null

    @PostMapping("login0409-do")
    fun login0409Do(
        model : Model,
        @RequestParam("username") uName : String,
        @RequestParam("password") uPwd : String
    ) : String
    {
        model.addAttribute("isLogin", true)
        if (userService!!.login(uName, uPwd))
            return "/0409/success"
        else
            return "/0409/faild"
    }


    @PostMapping("register0409-do")
    fun register0409Do(
        model : Model,
        @RequestParam("name") name: String,
        @RequestParam("password") pwd: String,
        @RequestParam("passwordRepeat") rptPwd: String
    ) : String
    {
        model.addAttribute("isLogin", false)
        val userDTO = registerUserDTO(name, pwd, rptPwd)
        if (userService!!.register(userDTO))
            return "/0409/success"
        else
            return "/0409/faild"
    }
}