package com.technipixl.and12_exo2

import android.Manifest
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.technipixl.and12_exo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //2. Création des variables
    companion object {
        private const val MY_SHARED_PREFERENCES = "EXO1_SHARED_PREFS"
        private const val FIRST_TIME_OPENING = "EXO1_FIRST_TIME_OPENING"
        private const val LOCATION_PERMISSION_REQUEST_CODE = 123
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var firstTimeOpening: Boolean = true

    //2.1 Déclarer FusedLocationProviderClient
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    //3.1
    private lateinit var locationCallback: LocationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        sharedPreferences =
            applicationContext.getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE)
        firstTimeOpening = sharedPreferences.getBoolean(FIRST_TIME_OPENING, true)

        //2.2 Instancier FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        //3.2
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult.lastLocation?.let { location ->
                    binding.latitude.text = "Latitude: ${location?.latitude.toString()}"
                    binding.longitude.text = "Longitude: ${location?.longitude.toString()}"

                }
            }
        }

        getLastKnowLocation()
    }

    private fun getLastKnowLocation() {
        //vérifier si l'application dispose des autorisations nécessaires pour accéder à la localisation de l'appareil.
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            //Si les autorisations ne sont pas accordées ou si c'est la première fois qu'elle est ouverte, demande à l'utilisateur d'accorder les autorisations en utilisant ActivityCompat.requestPermissions.
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) || firstTimeOpening
            ) {
                val editor = sharedPreferences.edit()
                editor.putBoolean(FIRST_TIME_OPENING, false)
                editor.apply()

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ),
                    LOCATION_PERMISSION_REQUEST_CODE
                )
            }

            return
        }


        val request = LocationRequest.Builder(1000)
            .setMinUpdateDistanceMeters(1f)
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
            .build()

        fusedLocationClient.lastLocation
            .addOnSuccessListener {
                binding.latitude.text = "Latitude: ${it?.latitude.toString()}"
                binding.longitude.text = "Longitude: ${it?.longitude.toString()}"
            }

        fusedLocationClient.requestLocationUpdates(
            request,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    //Cette méthode est appelée lorsque l'utilisateur répond à la demande d'autorisations. Si le code de demandé correspond au code de demande des autorisations de localisation
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            getLastKnowLocation()
        }
    }

}