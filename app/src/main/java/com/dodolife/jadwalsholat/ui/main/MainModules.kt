package com.dodolife.jadwalsholat.ui.main

import androidx.lifecycle.ViewModel
import com.dodolife.jadwalsholat.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModules {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel) : ViewModel
}