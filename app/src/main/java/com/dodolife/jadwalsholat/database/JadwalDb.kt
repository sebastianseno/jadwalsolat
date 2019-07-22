package com.dodolife.jadwalsholat.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SimpleSQLiteQuery
import com.dodolife.jadwalsholat.database.dao.PrayerTimesDao
import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb

@Database(
    entities = [
        PrayerTimesDb::class
    ], version = 4
)
abstract class JadwalDb : RoomDatabase() {

    abstract fun PrayerTimesDao(): PrayerTimesDao

    fun clearAndResetTable() {
        val query = SimpleSQLiteQuery("DELETE FROM sqlite_sequence")
        runInTransaction {
            clearAndResetTable()
            query(query)
        }
    }
}