package com.example.myapplication

import androidx.room.*

@Dao
interface xdDao {

    @Query("Select * from datos_persona")
    suspend fun mostrarJugadores():MutableList<xdEntity>

    @Query("Select * from datos_persona where nombre = :nombreJugador")
    suspend fun mostrarJugador(nombreJugador:String) : xdEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPersona(persona:xdEntity)

    @Update
    suspend fun updatetPersona(persona:xdEntity)

    @Delete
    suspend fun eliminarPersona(persona:xdEntity)
}