package com.alejoestrada.misdeudores.data.database.dao

import androidx.room.*
import com.alejoestrada.misdeudores.data.database.entities.Deudor

@Dao
interface DeudorDAO {

    @Insert
        fun insertDeudor(deudor: Deudor)
    @Query("SELECT * FROM tabla_deudor WHERE nombre like:nombre")
    fun searchDeudor(nombre: String): Deudor

    @Delete
    fun deleteDeudor(deudor:Deudor)

    @Update
    fun updateDeudor(deudor: Deudor)

    @Query("SELECT * FROM tabla_deudor")
    fun getDeudores(): List<Deudor>
}