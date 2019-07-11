package com.dodolife.jadwalsholat.inject

import com.dodolife.jadwalsholat.JadwalApp
import com.dodolife.jadwalsholat.network.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        AndroidSupportInjectionModule::class,
        NetworkModule::class

    ]
)
interface AppComponent : AndroidInjector<JadwalApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<JadwalApp>() {
        abstract override fun build(): AppComponent
    }
}