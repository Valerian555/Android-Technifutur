package com.technipixl.exo4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_BATTERY_LOW
import android.content.Intent.ACTION_BATTERY_OKAY
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var batteryLowBroadcastReceiver: BatteryStateBroadcastReceiver
    private lateinit var batteryOkBroadcastReceiver: BatteryStateBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Méthode de cycle de vie de l'acitivité, lorsque on passe à l'état "reprise"
    override fun onResume() {
        super.onResume()
        registerReceivers()
    }
    //Méthode de cycle de vie de l'acitivité, lorsque on passe à l'état "pause"
    override fun onPause() {
        super.onPause()
        unregisterReceivers()
    }

    private fun registerReceivers() {
        batteryLowBroadcastReceiver = BatteryStateBroadcastReceiver()
        registerReceiver(batteryLowBroadcastReceiver, IntentFilter(ACTION_BATTERY_LOW))

        batteryOkBroadcastReceiver = BatteryStateBroadcastReceiver()
        registerReceiver(batteryOkBroadcastReceiver, IntentFilter(ACTION_BATTERY_OKAY))
    }

    //sert à ne plus recevoir d'infos du broadcast
    private fun unregisterReceivers() {
        unregisterReceiver(batteryLowBroadcastReceiver)
        unregisterReceiver(batteryOkBroadcastReceiver)
    }
}

