package com.technipixl.and15_ex01_2_3

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.technipixl.and15_ex01_2_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //2.1
    companion object {
        private val CHANNEL_ID = if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.O) "Channel ID" else null
        private const val NOTIFICATION_ID = 1
    }

    private lateinit var binding: ActivityMainBinding
    val inboxStyle = NotificationCompat.InboxStyle()

    //1.2 Verification de la permission
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
            //Permission granted
            } else {
            //Permission denied
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //2.2Création des channels
        //vérifie la version. S'il s'agit d'Android 8.0 ou supérieur, il crée un canal de notification. (nécessaire ur Android 8.0 et supérieur.)
        // Cela permet de regrouper les notifications et de spécifier leur importance.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, "Channel name", NotificationManager.IMPORTANCE_HIGH)
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        //1.3
        when (ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.POST_NOTIFICATIONS)) {
            PackageManager.PERMISSION_GRANTED -> {
                //Permission granted, create channel
            }
            else -> {
                //Demande de permission
                requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
            }
        }

        val inboxNotificationContent = arrayListOf("Content1", "Content2", "Content3", "Content4")

        inboxNotificationContent.forEach {
            inboxStyle.addLine(it)
        }

        binding.sendNotificationButton.setOnClickListener {
            sendNotification()
        }

        binding.updateNotifButton.setOnClickListener {
            updateNotification()
        }

        binding.launchInboxNotifButton.setOnClickListener {
            sendInboxNotif()
        }
    }

    private fun sendNotification() {
        //3. Création de la notif
        val builder = NotificationCompat.Builder(this, CHANNEL_ID!!)
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setContentTitle("Test")
            .setContentText("Content")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setLargeIcon(BitmapFactory.decodeResource(
                resources,
                R.drawable.bell
            ))

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, builder.build())
        }
    }

    private fun updateNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID!!)
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setContentTitle("Test")
            .setContentText("New Content")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setLargeIcon(BitmapFactory.decodeResource(
                resources,
                R.drawable.bell
            ))

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, builder.build())
        }
    }

    private fun sendInboxNotif() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID!!)
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setContentTitle("Test")
            .setContentText("New Content")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(inboxStyle)
            .setLargeIcon(BitmapFactory.decodeResource(
                resources,
                R.drawable.bell
            ))

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, builder.build())
        }
    }
}