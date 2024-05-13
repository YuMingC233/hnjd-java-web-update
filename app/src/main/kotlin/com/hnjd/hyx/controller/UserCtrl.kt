package com.hnjd.hyx.controller

import cn.hutool.json.JSONObject
import com.hnjd.hyx.user.pojo.`do`.user
import com.hnjd.hyx.user.pojo.vo.registerUserDTO
import com.hnjd.hyx.user.service.IUserService
import com.hnjd.hyx.utils.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserCtrl {
    @Autowired
    lateinit var userService: IUserService

    @PostMapping("login")
    fun login(
        @RequestBody body : JSONObject
    ) : ApiResponse<String>  {
        val username = body.getStr("username")
        val password = body.getStr("password")
        if (username == null || password == null) {
            return ApiResponse.error("用户名或密码不能为空")
        }
        if (userService.login(username, password)) {
            return ApiResponse.success("登录成功 :P")
        } else if (userService.loginAdmin(username, password)) {
            return ApiResponse.error("您不是管理员")
        }
        return ApiResponse.error("登录失败！")
    }

    @PostMapping("register")
    fun register(
        @RequestBody body : JSONObject
    ) : ApiResponse<String> {
        val username = body.getStr("username")
        val password = body.getStr("password")
        val repPassword = body.getStr("repeatPassword")

        try {
            if (userService.register(registerUserDTO(username, password, repPassword)))
                return ApiResponse.success("注册成功 :)")
        } catch (e : Exception) {
            return ApiResponse.error(e.message.toString())
        }
        return ApiResponse.error("注册失败！")
    }

    @PutMapping("modifyPwd")
    fun modifyPwd(
        @RequestBody body : JSONObject
    ) : ApiResponse<String> {
        val userName = body.getStr("userName")
        val oldPassword = body.getStr("oldPwd")
        val newPassword = body.getStr("newPwd")

        try {
            if (userService.modifyPwd(userName, oldPassword, newPassword))
                return ApiResponse.success("修改密码成功 :)")
        } catch (e : Exception) {
            return ApiResponse.error(e.message.toString())
        }
        return ApiResponse.error("修改密码失败！")
    }
}