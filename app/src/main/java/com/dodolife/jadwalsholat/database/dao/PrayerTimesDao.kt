package com.dodolife.jadwalsholat.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb

@Dao
interface PrayerTimesDao : BaseDao<PrayerTimesDb> {
    @Query("SELECT * FROM PrayerTimesDb")
    fun getPrayerTimes(): LiveData<List<PrayerTimesDb>>
}