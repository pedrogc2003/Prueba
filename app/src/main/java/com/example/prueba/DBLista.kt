package com.example.prueba

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ListaCompra::class), version = 1)
abstract class DBLista: RoomDatabase() {
    abstract fun listaDao(): ListaDao
}