package com.example.mykotlinapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.telephony.TelephonyManager
import android.util.Log

class MyService() : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        Log.e("MY_LOG", "MyService.onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("MY_LOG", "MyService.onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("MY_LOG", "MyService.onStartCommand")
        val number = intent!!.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
        Log.e("MY_LOG", "Call number:$number")
        return super.onStartCommand(intent, flags, startId)
    }
}
