package com.example.onboarding4.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pager::class], version = 1, exportSchema = false)
abstract class PagerDatabase : RoomDatabase() {
    abstract fun bookDao(): PagerDoa

    companion object {
        @Volatile
        private var INSTANS: PagerDatabase? = null


        fun getDatebase(context: Context): PagerDatabase {
            val tampleInstans = INSTANS
            if (tampleInstans != null) {
                return tampleInstans
            }
            synchronized(this) {
                val instans = Room.databaseBuilder(
                    context.applicationContext,
                    PagerDatabase::class.java,
                    "table_name"
                ).build()
                INSTANS = instans
                return instans
            }
        }
    }
}