package com.juan.equipoec4.data.retrofilt

import com.juan.equipoec4.data.retrofilt.responce.EquipoListResponce
import retrofit2.http.GET

interface Service {
    @GET("football/teams?api_token=KGvmEHD7Vjpihj4kPlMpRVS4x1KmgKl4HFd0bUMt81yWs8aSmxbCCQILPPpq")
    suspend fun  getEquipos() :EquipoListResponce
}