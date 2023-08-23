package com.juan.equipoec4.data.retrofilt.repository

import com.juan.equipoec4.data.retrofilt.ServiceInstance
import com.juan.equipoec4.data.retrofilt.db.EquipoDao
import com.juan.equipoec4.data.retrofilt.responce.ApiResponse
import com.juan.equipoec4.data.retrofilt.responce.EquipoListResponce
import com.juan.equipoec4.model.Equipo
import java.lang.Exception

class EquiposRepository(val equipoDao: EquipoDao? = null) {


    suspend fun getEquipos(): ApiResponse<EquipoListResponce> {
        return try {
            val responce = ServiceInstance.getEquipoService().getEquipos()
            ApiResponse.Success(responce)
        } catch (e: Exception){
            ApiResponse.Error(e)
        }
    }
    suspend fun addFavorito(equipo: Equipo){
        equipoDao?.let {
            it.addFavorite(equipo )
        }
    }

    fun  getFavorites(): List<Equipo>{
        equipoDao?.let {
            return it.getFavoritos()
        } ?:kotlin.run {
            return listOf()
        }

    }
}