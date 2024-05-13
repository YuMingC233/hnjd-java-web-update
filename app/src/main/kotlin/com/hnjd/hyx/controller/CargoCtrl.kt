package com.hnjd.hyx.controller

import cn.hutool.json.JSONObject
import cn.hutool.json.JSONParser
import com.hnjd.hyx.user.pojo.`do`.logisticsInfo
import com.hnjd.hyx.user.service.ILogisticsInfoService
import com.hnjd.hyx.utils.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cargo")
class CargoCtrl{

    @Autowired
    private lateinit var cargoService: ILogisticsInfoService

    @GetMapping("/get")
    fun get() : List<logisticsInfo>{
        return cargoService.getAll()
    }

    @GetMapping("/get/{id}")
    fun getbyId(
        @PathVariable("id") id: Int
    ) : ApiResponse<JSONObject> {
        return ApiResponse.success(JSONObject(cargoService.getById(id)))
    }


    @PostMapping("/add")
    fun add(@RequestBody logisticsInfo: logisticsInfo): Boolean{
        return cargoService.add(logisticsInfo)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody obj : JSONObject): Boolean{
        return cargoService.delete(obj.getInt("id"))
    }

    @PutMapping("/update")
    fun update(@RequestBody logisticsInfo: logisticsInfo): Boolean{
        return cargoService.update(logisticsInfo)
    }
}