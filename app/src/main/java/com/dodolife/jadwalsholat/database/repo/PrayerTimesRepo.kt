package com.dodolife.jadwalsholat.database.repo

import com.dodolife.jadwalsholat.database.JadwalDb
import com.dodolife.jadwalsholat.database.dao.PrayerTimesDao
import com.dodolife.jadwalsholat.database.toDb
import com.dodolife.jadwalsholat.network.service.PrayerTimesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.DecimalFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrayerTimesRepo @Inject constructor(
    private val prayerTimesService: PrayerTimesService,
    jadwalDb: JadwalDb
) {

    private val prayerTimesDao: PrayerTimesDao = jadwalDb.PrayerTimesDao()

    suspend fun getPrayerTimes(
        latitude: Double,
        longitude: Double
    ) = withContext(Dispatchers.IO) {
        val response = prayerTimesService.getPrayerTimes(latitude,longitude).await()
        prayerTimesDao.insert(response.data.map { it.toDb() })
    }
}