package com.hnjd.hyx.user.pojo.vo

class registerUserDTO constructor() {
    var name: String? = null
    var password: String? = null
    var passwordRepeat: String? = null

    constructor(name: String, password: String, passwordRepeat: String) : this() {
        this.name = name
        this.password = password
        this.passwordRepeat = passwordRepeat
    }
}