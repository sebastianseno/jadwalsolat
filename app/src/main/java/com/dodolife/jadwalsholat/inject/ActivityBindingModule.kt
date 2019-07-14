package com.dodolife.jadwalsholat.inject

import com.dodolife.jadwalsholat.ui.main.MainActivity
import com.dodolife.jadwalsholat.ui.main.MainModules
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            MainModules::class
        ]
    )
    @ActivityScope
    abstract fun mainActivity(): MainActivity

}