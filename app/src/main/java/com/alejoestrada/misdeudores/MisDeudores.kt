package com.alejoestrada.misdeudores

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alejoestrada.misdeudores.data.DeudorDatabase

class MisDeudores: Application() {

    companion object{
        lateinit var  database: DeudorDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database= Room.databaseBuilder(
            this,DeudorDatabase::class.java,
            "deudor_DB"
        ).allowMainThreadQueries()
            .build()



    }
}