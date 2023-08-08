package com.example.individual_8.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RazaEntity::class], version = 1)
abstract class Cliente: RoomDatabase() {
    abstract fun getRazaDao(): RazaDao

    companion object {
        @Volatile
        private var INSTANCE: Cliente? = null

        fun getDatabase(context: Context) : Cliente {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Cliente::class.java,
                    "razas_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}