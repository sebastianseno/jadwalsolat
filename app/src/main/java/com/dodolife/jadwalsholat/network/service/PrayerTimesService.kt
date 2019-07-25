package com.dodolife.jadwalsholat.network.service

import com.dodolife.jadwalsholat.network.entity.PrayerTimesData
import com.dodolife.jadwalsholat.network.entity.Response
import com.dodolife.jadwalsholat.network.entity.TimingsData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerTimesService {

    @GET("v1/calendar")
    fun getPrayerTimes(
        @Query("latitude") latitude : Double,
        @Query("longitude") longitude : Double,
        @Query("method") method : Int = 2
    ): Deferred<Response<List<TimingsData>>>

    @GET("v1/calendarByAddress")
    fun getPrayerTimesByAddress(
        @Query("address") address : String
    ): Deferred<Response<List<PrayerTimesData>>>
}