package com.hnjd.hyx.user.pojo.`do`

import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data

@TableName("user")
class user {
    // 属性真的有必要使用private修饰吗？
    // 参见：https://juejin.cn/post/7206627150622031931
    var id: Int? = null
    var name: String? = null
    var password: String? = null
}