package com.dodolife.jadwalsholat.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import com.dodolife.jadwalsholat.inject.BaseActivity

inline fun <reified T : ViewModel> BaseActivity.getViewModel() =
    lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, viewModelFactory)[T::class.java]
    }

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

inline fun <T : Any, L : LiveData<T>> LifecycleOwner.observeNonNull(
    liveData: L,
    crossinline body: (T) -> Unit
) {
    liveData.observe(this, Observer { it?.let(body) })
}