package com.dodolife.jadwalsholat.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.dodolife.jadwalsholat.R
import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb
import com.dodolife.jadwalsholat.inject.BaseActivity
import com.dodolife.jadwalsholat.utils.getViewModel
import com.dodolife.jadwalsholat.utils.observe
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val viewModel by getViewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, getString(R.string.google_maps_key))
        }

        searchLocation.setOnClickListener {
            openAutoComplete()
        }

        observe(viewModel.allPrayerTimes, ::displayData)
    }

    private fun openAutoComplete() {
        val intent = Autocomplete.IntentBuilder(
            AutocompleteActivityMode.OVERLAY,
            listOf(Place.Field.ADDRESS, Place.Field.LAT_LNG)
        ).setCountry("ID")
            .build(this)
        startActivityForResult(
            intent,
            AUTOCOMPLETE_REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val place = Autocomplete.getPlaceFromIntent(data!!)
                val latLng = place.latLng
                locationSelect.text = place.address
                viewModel.getPrayerTimes(latLng!!.latitude, latLng.longitude)
            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun displayData(prayerTimesDb: PrayerTimesDb?) {
        fajrTime.text = prayerTimesDb?.subuh
        dhuhurTime.text = prayerTimesDb?.dhuhur
        asharTime.text = prayerTimesDb?.ashar
        maghribTime.text = prayerTimesDb?.maghrib
        isyaTime.text = prayerTimesDb?.isya
    }

    companion object {
        private const val AUTOCOMPLETE_REQUEST_CODE = 102

    }
}