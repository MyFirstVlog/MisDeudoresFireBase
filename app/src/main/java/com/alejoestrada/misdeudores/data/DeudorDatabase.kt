package com.alejoestrada.misdeudores.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alejoestrada.misdeudores.data.database.dao.DeudorDAO
import com.alejoestrada.misdeudores.data.database.entities.Deudor


@Database(entities = [Deudor::class], version = 1)
abstract class DeudorDatabase:RoomDatabase() {
    abstract fun DeudorDAO(): DeudorDAO
}