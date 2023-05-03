package com.example.prueba

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ListaDao {
    @Query("SELECT * FROM lista_compra")
    fun getAllElements(): MutableList<ListaCompra>

    @Insert
    fun addElemento(taskEntity: ListaCompra):Long

    @Query("SELECT * FROM lista_compra WHERE id like :id")
    fun getElementoId(id: Long):ListaCompra

    @Update
    fun updateLista(taskEntity: ListaCompra):Int

    @Delete
    fun deleteLista(taskEntity: ListaCompra):Int
}