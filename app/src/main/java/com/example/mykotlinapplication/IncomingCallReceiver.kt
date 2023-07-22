package com.example.mykotlinapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class IncomingCallReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val number = intent?.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
        if (number != null) {
            Log.e("MY_CALL", "Number: $number")
            intent?.setClass(context!!, MyService::class.java)
            context?.startService(intent)
            context?.stopService(intent)
        }
    }
}