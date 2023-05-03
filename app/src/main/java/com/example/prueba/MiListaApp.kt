package com.example.prueba

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class MiListaApp: Application() {

    companion object{
        lateinit var database: DBLista
    }

    override fun onCreate() {
        super.onCreate()
        MiListaApp.database = Room.databaseBuilder(this, DBLista::class.java, "DBLista").build()
    }

}