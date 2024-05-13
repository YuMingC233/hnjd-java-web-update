package com.hnjd.hyx.user.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.hnjd.hyx.user.mapper.userMapper
import com.hnjd.hyx.user.pojo.`do`.user
import com.hnjd.hyx.user.pojo.vo.registerUserDTO
import com.hnjd.hyx.user.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
// : 冒号是继承，这里是继承ServiceImpl<userMapper, user>类
//  并且实现了userService接口
class IUserServiceImpl: ServiceImpl<userMapper, user>(), IUserService {
    @Autowired
    private lateinit var userMapper: userMapper

    override fun login(name: String, password: String): Boolean {
        val queryWrapper : QueryWrapper<user> = QueryWrapper<user>()
            .eq("name", name)
            .eq("password", password)
        return this.count(queryWrapper) == 1.toLong()
    }

    override fun loginAdmin(name: String, password: String): Boolean {
        val queryWrapper : QueryWrapper<user> = QueryWrapper<user>()
            .eq("name", name)
            .eq("password", password)
        return this.count(queryWrapper) == 1.toLong()
    }

    override fun register(userDTO: registerUserDTO): Boolean {
        val user = user()
        if (userDTO.name == null || userDTO.password == null || userDTO.passwordRepeat == null) {
            return false
        } else if (userDTO.password != userDTO.passwordRepeat) {
            return false
        }

        user.name = userDTO.name
        user.password = userDTO.password

        return this.save(user)
    }

    override fun modifyPwd(userName: String, oldPwd: String, newPwd: String): Boolean {
        // 查找对应账号信息
        val user = userMapper.selectOne(QueryWrapper<user>().eq("name", userName)) as user
        // 判断旧密码是否正确
        if (user.password != oldPwd) {
            return false
        }

        // 更新密码
        return update(UpdateWrapper<user>().eq("name", user.name).set("password", newPwd))
    }
}