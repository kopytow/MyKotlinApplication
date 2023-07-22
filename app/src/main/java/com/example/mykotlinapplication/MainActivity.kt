package com.example.mykotlinapplication

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MY_LOG", "MainActivity.onCreate")
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_launch).setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("KEY_STRING", "Hello word!")
            startActivity(intent)
        }
        findViewById<Button>(R.id.button_launch_service).setOnClickListener {
            val intent = Intent(this@MainActivity, MyService::class.java)
            startService(intent)
            bindService(intent, object : ServiceConnection {
                override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {}
                override fun onServiceDisconnected(componentName: ComponentName) {}
            }, BIND_AUTO_CREATE)
        }
        findViewById<Button>(R.id.button_explore_contacts).setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val cursor = contentResolver.query(
                    ContactsContract.Contacts.CONTENT_URI,
                    null,
                    null,
                    null
                )
                if (cursor != null) {
                    if (cursor.isBeforeFirst) cursor.moveToNext()
                    do {
                        val index =
                            cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                        val name = cursor.getString(index)
                        Log.e("MY_CONTACTS", "Name = $name")
                    } while (cursor.moveToNext())
                    cursor.close()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("MY_LOG", "MainActivity.onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MY_LOG", "MainActivity.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MY_LOG", "MainActivity.onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MY_LOG", "MainActivity.onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MY_LOG", "MainActivity.onResume")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }
}