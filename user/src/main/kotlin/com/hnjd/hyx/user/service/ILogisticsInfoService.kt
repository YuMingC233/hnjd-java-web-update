package com.hnjd.hyx.user.service

import com.baomidou.mybatisplus.extension.service.IService
import com.hnjd.hyx.user.pojo.`do`.logisticsInfo

interface ILogisticsInfoService: IService<logisticsInfo> {
    /**
     * 添加物流信息
     */
    fun add(logisticsInfo: logisticsInfo): Boolean

    /**
     * 删除指定物流信息
     */
    fun delete(id: Int): Boolean

    /**
     * 修改指定物流信息
     */
    fun update(logisticsInfo: logisticsInfo): Boolean

    /**
     * 获取所有物流信息
     */
    fun getAll(): List<logisticsInfo>

    /**
     * 根据ID获取指定物流信息
     */
    fun getById(id: Int): logisticsInfo
}