package com.dodolife.jadwalsholat.ui.main

import android.util.Log
import com.dodolife.jadwalsholat.database.repo.PrayerTimesRepo
import com.dodolife.jadwalsholat.utils.BaseViewModel
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val prayerTimesRepo: PrayerTimesRepo
) : BaseViewModel() {

    fun getPrayerTimes(latitude: Double, longitude:Double) {
        launch {
            try {
                prayerTimesRepo.getPrayerTimes(latitude,longitude)
            } catch (e:Exception) {
                Log.e("Prayer Times","Error Result",e)
            }
        }
    }

}