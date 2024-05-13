package com.hnjd.hyx.user.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.hnjd.hyx.user.mapper.logisticsMapper
import com.hnjd.hyx.user.mapper.userMapper
import com.hnjd.hyx.user.pojo.`do`.logisticsInfo
import com.hnjd.hyx.user.pojo.`do`.user
import com.hnjd.hyx.user.service.ILogisticsInfoService
import com.hnjd.hyx.user.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ILogisticsInfoServiceImpl : ServiceImpl<logisticsMapper, logisticsInfo>(), ILogisticsInfoService {

    @Autowired
    private lateinit var logisticsMapper: logisticsMapper

    override fun add(logisticsInfo: logisticsInfo): Boolean {
        return save(logisticsInfo)
    }

    override fun update(logisticsInfo: logisticsInfo): Boolean {
        return updateById(logisticsInfo)
    }

    override fun delete(id: Int): Boolean {
        return removeById(id)
    }

    override fun getAll(): List<logisticsInfo> {
        return list()
    }

    override fun getById(id: Int): logisticsInfo {
        logisticsMapper.selectById(id).let {
            return it
        }
    }
}