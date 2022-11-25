package com.example.veritiesworkservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast


class MusicPlayService  : Service() {
    var musicPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        Toast.makeText(this, "Music Service started by user.", Toast.LENGTH_LONG).show();
        musicPlayer!!.start();
        return START_STICKY;
    }

    override fun onCreate() {
        super.onCreate()
        musicPlayer = MediaPlayer.create(this, R.raw.the_romantics_sleep_ringtone);
        musicPlayer!!.setLooping(false);
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer!!.stop();
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        musicPlayer!!.start();
    }


}