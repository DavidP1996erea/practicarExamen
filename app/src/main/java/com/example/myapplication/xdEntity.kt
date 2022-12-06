package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "datos_persona")
data class xdEntity(

    @PrimaryKey
    var nombre:String,
    var telefono:Int=0,
    var direccion:String=""

)
