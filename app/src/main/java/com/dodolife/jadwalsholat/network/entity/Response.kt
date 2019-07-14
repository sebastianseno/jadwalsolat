package com.dodolife.jadwalsholat.network.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
class Response<out S>(
    @Json(name = "code") val code : Int,
    @Json(name = "status") val status : String,
    @Json(name = "data") val data : S
)

@JsonClass(generateAdapter = true)
class ErrorResponse (
    @Json(name = "code") val code : Int,
    @Json(name = "status") val status: String,
    @Json(name = "message") val message: String
)