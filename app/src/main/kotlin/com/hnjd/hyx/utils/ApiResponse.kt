package com.hnjd.hyx.utils



data class ApiResponse<T>(val status: Int, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(200, data, "操作成功 :)")
        }

        fun <T> success(msg: String): ApiResponse<T> {
            return ApiResponse(200,null, msg)
        }

        fun <T> error(msg: String, data: T?): ApiResponse<T> {
            return ApiResponse(400, data, msg)
        }

        fun <T> error(msg: String): ApiResponse<T> {
            return ApiResponse(400, null, msg)
        }

        fun <T> loading(data: T?): ApiResponse<T> {
            return ApiResponse(696, data, null)
        }
    }
}
