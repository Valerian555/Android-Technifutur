package com.technipixl.exo3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.technipixl.exo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    //Ne pas oublier de rajouter la permission dans le manifest
    private val phoneCallPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        val uri = Uri.parse("tel:${binding.phoneInput.text}")
        val intent = Intent(Intent.ACTION_CALL, uri)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun openDial(view: View){
        phoneCallPermissionLauncher.launch((android.Manifest.permission.CALL_PHONE))
    }
}