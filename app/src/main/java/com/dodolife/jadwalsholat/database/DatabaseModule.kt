package com.dodolife.jadwalsholat.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun roomBuilder(context: Context): JadwalDb {
        return Room.databaseBuilder(context, JadwalDb::class.java, "jadwal.db")
            .fallbackToDestructiveMigration()
            .build()

    }
}