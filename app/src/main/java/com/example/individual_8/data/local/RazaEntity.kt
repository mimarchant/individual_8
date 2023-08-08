package com.example.individual_8.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_razas")
class RazaEntity (
    @PrimaryKey(autoGenerate = true) var id: Long,
    val raza: String
        )