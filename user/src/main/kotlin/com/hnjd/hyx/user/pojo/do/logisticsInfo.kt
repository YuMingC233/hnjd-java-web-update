package com.hnjd.hyx.user.pojo.`do`

import cn.hutool.core.date.DateTime
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.util.Date

@TableName("logistics_info")
class logisticsInfo {
    fun setId(int: Int?): logisticsInfo {
        this.id = int
        return this
    }

    @TableId("id", type = IdType.AUTO)
    var id: Int? = null
    @TableField("number")
    var number: Int? = null
    @TableField("message")
    var message: String? = null
    @TableField("shipping_address")
    var shippingAddress: String? = null
    @TableField("delivery_address")
    var deliveryAddress: String? = null
    @TableField("price")
    var price: Double? = null
    @TableField("date")
    var date: Date? = null
    @TableField("courier")
    var courier: String? = null
}