package com.example.individual_8.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.individual_8.data.Repositorio
import com.example.individual_8.data.local.Cliente
import com.example.individual_8.data.remote.RetrofitClient
import kotlinx.coroutines.launch

class RazaViewModel (application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val api = RetrofitClient.getRetrofitRaza()
        val razaDatabase = Cliente.getDatabase(application).getRazaDao()

        repositorio = Repositorio(api, razaDatabase)
    }

    fun getAllRazas() = viewModelScope.launch {
        repositorio.getRazas()
    }


}