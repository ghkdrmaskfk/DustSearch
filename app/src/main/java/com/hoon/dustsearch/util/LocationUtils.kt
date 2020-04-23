package com.hoon.dustsearch.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.hoon.dustsearch.Application
import com.hoon.dustsearch.Application.Companion.applicationContext
import java.io.IOException
import java.util.*
import java.util.jar.Manifest

class LocationUtils {

    val TAG = "LocationUtils"

    var locationManager: LocationManager? = null
    private val REQUEST_CODE_LOCATION: Int = 2
    var currentLocation: String = ""
    var latitude: Double? = null
    var longitude: Double? = null

    fun getCurrentLocation(activity: Activity) {

        locationManager = activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager?

        var userLocation: Location = getLatLng(activity)
        if (userLocation != null) {
            latitude = userLocation.latitude
            longitude = userLocation.longitude
            Log.e(TAG, "현재 내 위치 값 : $latitude, $longitude")
        }

        var mGeocoder = Geocoder(applicationContext(), Locale.KOREAN)
        var result: List<Address>? = null
        try{
            result = mGeocoder.getFromLocation(
                latitude!!, longitude!!, 1
            )
        } catch(e: IOException){
            e.printStackTrace()
        }
        if (result != null) {
            Log.e(TAG, result[0].getAddressLine(0))

            currentLocation = result[0].getAddressLine(0)
            currentLocation = currentLocation.substring(11)
        }
    }

    fun getLatLng(activity: Activity) : Location {
        var currentLatLng: Location? = null
        if (ActivityCompat.checkSelfPermission(applicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(applicationContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_CODE_LOCATION)
            getLatLng(activity)

        } else {

            val locationProvider = LocationManager.GPS_PROVIDER
                currentLatLng = locationManager?.getLastKnownLocation(locationProvider)

        }
        return currentLatLng!!
    }
}