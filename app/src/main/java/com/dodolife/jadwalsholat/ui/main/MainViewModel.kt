package com.dodolife.jadwalsholat.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb
import com.dodolife.jadwalsholat.database.entity.PrayerTimesSummary
import com.dodolife.jadwalsholat.database.repo.PrayerTimesRepo
import com.dodolife.jadwalsholat.utils.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val prayerTimesRepo: PrayerTimesRepo
) : BaseViewModel() {

    val allPrayerTimes: LiveData<PrayerTimesDb>
        get() = prayerTimesRepo.getAllPrayerTimesFromQuerry()

    fun getPrayerTimes(latitude: Double, longitude: Double) {
        launch {
            try {
                prayerTimesRepo.getPrayerTimes(latitude, longitude)
            } catch (e: Exception) {
                Log.e("Prayer Times", "Error Result", e)
            }
        }
    }

    fun getPrayerTimesByAddress(address: String) {
        launch {
            try {
                prayerTimesRepo.getPrayerTimesByAddress(address)
            } catch (e: Exception) {
                Log.e("Prayer Times", "Error Result", e)
            }
        }
    }

}