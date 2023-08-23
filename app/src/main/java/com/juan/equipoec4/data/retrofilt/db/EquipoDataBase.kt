package com.juan.equipoec4.data.retrofilt.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juan.equipoec4.model.Equipo

@Database(entities = [Equipo::class], version = 1)
abstract class EquipoDataBase:RoomDatabase() {

    abstract fun equipoDao(): EquipoDao

    companion object{
        @Volatile
        private var intance: EquipoDataBase? = null
        fun getDatabase(context: Context): EquipoDataBase{
            if (intance == null) {
                synchronized(this){
                    intance = buildDatabase(context)
                }
            }
            return intance!!
        }

        private fun buildDatabase(context: Context): EquipoDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                EquipoDataBase::class.java,
                "equipo_database"
            ).build()
        }


    }
}