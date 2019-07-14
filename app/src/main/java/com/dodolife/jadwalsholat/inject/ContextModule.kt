package com.dodolife.jadwalsholat.inject

import android.content.Context
import com.dodolife.jadwalsholat.JadwalApp
import dagger.Binds
import dagger.Module

@Module
abstract class ContextModule {

    @Binds
    abstract fun bindContext(jadwalApp: JadwalApp): Context
}