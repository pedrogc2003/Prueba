package com.example.prueba

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lista_compra")
data class ListaCompra (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var nombre:String = "",
    var activo:Boolean = false
)