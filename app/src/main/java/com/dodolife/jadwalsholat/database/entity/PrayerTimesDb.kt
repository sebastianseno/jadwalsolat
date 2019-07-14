package com.dodolife.jadwalsholat.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PrayerTimesDb(
    @PrimaryKey
    val subuh   : String,
    val sunrise : String,
    val dhuhur  : String,
    val ashar   : String,
    val maghrib : String,
    val isya    : String
) {
    override fun toString(): String {
        return super.toString()
    }
}