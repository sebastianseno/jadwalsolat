package com.dodolife.jadwalsholat.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb

@Dao
abstract class PrayerTimesDao : BaseDao<PrayerTimesDb> {

    @Query("SELECT * FROM PrayerTimesDb ORDER BY id DESC")
    abstract fun getPrayerTimes(): LiveData<List<PrayerTimesDb>>

}