package com.technipixl.and12_exo1

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.provider.ProviderProperties.ACCURACY_FINE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.technipixl.and12_exo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LocationListener {
    //2. Création des variables
    companion object {
        private const val MY_SHARED_PREFERENCES = "EXO1_SHARED_PREFS"
        private const val FIRST_TIME_OPENING = "EXO1_FIRST_TIME_OPENING"
        private const val LOCATION_PERMISSION_REQUEST_CODE = 123
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var firstTimeOpening: Boolean = true
    private lateinit var locationManager: LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //4. Initialisation
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        sharedPreferences = applicationContext.getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE)
        firstTimeOpening = sharedPreferences.getBoolean(FIRST_TIME_OPENING, true)

        //5. appel de la fonction
        getLastKnowLocation()
    }

    //3. Création de la fct récupérant la dernière position et gérant les permissions
    private fun getLastKnowLocation() {
        //vérifier si l'application dispose des autorisations nécessaires pour accéder à la localisation de l'appareil.
        if(ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {

            //Si les autorisations ne sont pas accordées ou si c'est la première fois qu'elle est ouverte, demande à l'utilisateur d'accorder les autorisations en utilisant ActivityCompat.requestPermissions.
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, ACCESS_FINE_LOCATION) || firstTimeOpening) {
                val editor = sharedPreferences.edit()
                editor.putBoolean(FIRST_TIME_OPENING, false)
                editor.apply()

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION),
                    LOCATION_PERMISSION_REQUEST_CODE
                )
            }

            return
        }

        //Si les autorisations sont accordées, configuré pour privilégier une localisation précise (Criteria.ACCURACY_FINE).
        locationManager.getBestProvider(Criteria().apply {
            this.accuracy = Criteria.ACCURACY_FINE
        }, true) ?.let { provider ->
            //Demande des mises à jour de localisation. Elle spécifie une fréquence minimale de 100 millisecondes et une distance minimale de 1 mètre entre les mises à jour.
            locationManager.requestLocationUpdates(provider, 100, 1f, this)
        }
    }

    //Cette méthode est appelée lorsque l'utilisateur répond à la demande d'autorisations. Si le code de demandé correspond au code de demande des autorisations de localisation
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            if(requestCode== LOCATION_PERMISSION_REQUEST_CODE) {
                getLastKnowLocation()
            }
        }

    //6. Ecouter les changements et mettre à jour l'UI
    override fun onLocationChanged(location: Location) {
        locationManager.removeUpdates(this)
        binding.latitude.text = "Latitude: ${location?.latitude.toString()}"
        binding.longitude.text = "Longitude: ${location?.longitude.toString()}"
    }
}