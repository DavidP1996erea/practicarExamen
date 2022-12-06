package com.example.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [xdEntity::class], version = 1)
abstract class xdDataBase : RoomDatabase() {

        abstract fun xdDao() : xdDao
}
