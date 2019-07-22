package com.dodolife.jadwalsholat.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PrayerTimesDb(

    val subuh   : String,
    val sunrise : String,
    val dhuhur  : String,
    val ashar   : String,
    val maghrib : String,
    val isya    : String,
    val name : String
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}