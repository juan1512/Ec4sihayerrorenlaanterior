package com.juan.equipoec4.data.retrofilt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juan.equipoec4.model.Equipo


@Dao
interface EquipoDao {
    @Query("SELECT * FROM equipo")
    fun getFavoritos():List<Equipo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(equipo: Equipo)
}