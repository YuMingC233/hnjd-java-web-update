package com.hnjd.hyx.user.service

import com.baomidou.mybatisplus.extension.service.IService
import com.hnjd.hyx.user.pojo.`do`.user
import com.hnjd.hyx.user.pojo.vo.registerUserDTO


interface IUserService : IService<user> {
    // 登录方法
    fun login(name: String, password: String): Boolean

    // 登录方法
    fun loginAdmin(name: String, password: String): Boolean

    // 注册方法
    fun register(userDTO: registerUserDTO): Boolean

    // 修改密码
    fun modifyPwd(userName: String, oldPwd: String, newPwd: String): Boolean
}