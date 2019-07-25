package com.dodolife.jadwalsholat.database.repo

import androidx.lifecycle.LiveData
import com.dodolife.jadwalsholat.database.JadwalDb
import com.dodolife.jadwalsholat.database.dao.PrayerTimesDao
import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb
import com.dodolife.jadwalsholat.database.entity.PrayerTimesSummary
import com.dodolife.jadwalsholat.database.toDb
import com.dodolife.jadwalsholat.database.toDbPrayer
import com.dodolife.jadwalsholat.network.service.PrayerTimesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrayerTimesRepo @Inject constructor(
    private val prayerTimesService: PrayerTimesService,
    jadwalDb: JadwalDb
) {

    private val prayerTimesDao: PrayerTimesDao = jadwalDb.PrayerTimesDao()

    fun getAllPrayerTimesFromQuerry(): LiveData<PrayerTimesDb> {
        return prayerTimesDao.getPrayerTimes()
    }

    suspend fun getPrayerTimes(
        latitude: Double,
        longitude: Double
    ) = withContext(Dispatchers.IO) {
        val response = prayerTimesService.getPrayerTimes(latitude,longitude).await()
        prayerTimesDao.insert(response.data.map { it.toDbPrayer() })
    }


    suspend fun getPrayerTimesByAddress(
        address : String
    ) = withContext(Dispatchers.IO) {
        val response = prayerTimesService.getPrayerTimesByAddress(address).await()
        prayerTimesDao.insert(response.data.map { it.toDb() })
    }
}