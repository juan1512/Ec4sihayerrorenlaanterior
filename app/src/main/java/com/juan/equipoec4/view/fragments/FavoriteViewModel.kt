package com.juan.equipoec4.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.juan.equipoec4.data.retrofilt.db.EquipoDataBase
import com.juan.equipoec4.data.retrofilt.repository.EquiposRepository
import com.juan.equipoec4.model.Equipo

class FavoriteViewModel(application: Application):AndroidViewModel(application) {
    private val repository: EquiposRepository
    private val _favotires: MutableLiveData<List<Equipo>> = MutableLiveData()
    val favorites: LiveData<List<Equipo>> = _favotires
    init {
        val db = EquipoDataBase.getDatabase(application)
        repository = EquiposRepository(db.equipoDao())

    }
    fun getFavotires(){
        val data = repository.getFavorites()
        _favotires.value = data
    }



}
