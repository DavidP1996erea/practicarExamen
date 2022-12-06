package com.example.myapplication

import android.app.Application
import androidx.room.Room

class xdApp: Application() {

    companion object {
        lateinit var database: xdDataBase
    }

    override fun onCreate() {
        super.onCreate()
        xdApp.database = Room.databaseBuilder(this, xdDataBase::class.java, "pruebaBaseDatos").build()
    }
}