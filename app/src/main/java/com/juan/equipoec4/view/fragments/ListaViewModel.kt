package com.juan.equipoec4.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.equipoec4.data.retrofilt.repository.EquiposRepository
import com.juan.equipoec4.data.retrofilt.responce.ApiResponse
import com.juan.equipoec4.model.Equipo
import com.juan.equipoec4.model.getData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListaViewModel: ViewModel() {

    val respository = EquiposRepository()
    val equipolist: MutableLiveData<List<Equipo>> = MutableLiveData<List<Equipo>>()

    fun getListE(){
        val data = getData()
        equipolist.value = data
    }
    fun getEquipossFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = respository.getEquipos()
            when (response) {
                is ApiResponse.Error -> {

                }
                is ApiResponse.Success -> {

                    equipolist.postValue(response.data.data)
                }
            }

        }
    }

}