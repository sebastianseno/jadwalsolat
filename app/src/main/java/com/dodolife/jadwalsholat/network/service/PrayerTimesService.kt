package com.dodolife.jadwalsholat.network.service

import com.dodolife.jadwalsholat.network.entity.PrayerTimesData
import com.dodolife.jadwalsholat.network.entity.Response
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerTimesService {

    @GET("v1/calendar")
    fun getPrayerTimes(
        @Query("latitude") latitude : Long,
        @Query("longitude") longitude : Long,
        @Query("method") method : Int = 2
    ): Deferred<Response<List<PrayerTimesData>>>
}