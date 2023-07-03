package com.technipixl.exo4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BatteryStateBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("onReceive", "batteryStateBroadcastReceiver was called")

        intent?.action?.let { action ->
            when (action) {
                Intent.ACTION_BATTERY_OKAY -> Log.d("onReceive", "Battery level is okay")
                Intent.ACTION_BATTERY_LOW -> Log.d("onReceive", "Battery level is low")
                else -> Log.d("onReceive", action)
            }
        }
    }
}