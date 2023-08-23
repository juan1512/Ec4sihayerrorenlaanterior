package com.juan.equipoec4.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.equipoec4.data.retrofilt.db.EquipoDataBase
import com.juan.equipoec4.data.retrofilt.repository.EquiposRepository
import com.juan.equipoec4.model.Equipo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetallesViewModel(application: Application): AndroidViewModel(application){
    private val repository: EquiposRepository

    init {
        val db = EquipoDataBase.getDatabase(application)
        repository = EquiposRepository(db.equipoDao())

    }
    fun addFavorite(equipo: Equipo){
        viewModelScope.launch(Dispatchers.IO){
            repository.addFavorito(equipo)
        }
    }


}