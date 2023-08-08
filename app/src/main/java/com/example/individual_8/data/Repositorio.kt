package com.example.individual_8.data

import com.example.individual_8.data.local.RazaDao
import com.example.individual_8.data.local.RazaEntity
import com.example.individual_8.data.remote.RazaPerroApi
import retrofit2.Response

class Repositorio(private val razaApi: RazaPerroApi, private val razaDao: RazaDao) {
    suspend fun getRazas() {
        val response = razaApi.getData()

        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys = message.keys

            keys.forEach {
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)
            }

        }
    }
}