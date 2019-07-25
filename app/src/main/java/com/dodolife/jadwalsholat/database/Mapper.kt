package com.dodolife.jadwalsholat.database

import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb
import com.dodolife.jadwalsholat.network.entity.PrayerTimesData
import com.dodolife.jadwalsholat.network.entity.TimingsData

fun PrayerTimesData.toDb(): PrayerTimesDb {
    return PrayerTimesDb(
        fajr,
        sunrise,
        dhuhur,ashar,
        maghrib,
        isha
    )
}

fun TimingsData.toDbPrayer(): PrayerTimesDb {
    return PrayerTimesDb(
        prayerTimesData?.fajr, prayerTimesData?.sunrise, prayerTimesData?.dhuhur, prayerTimesData?.ashar, prayerTimesData?.maghrib, prayerTimesData?.isha
    )
}