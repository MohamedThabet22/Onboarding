package com.example.onboarding4.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.onboarding4.mvvm.Pager

@Dao
interface PagerDoa {
    @Query("SELECT * FROM pager_table LIMIT 1")
    fun getPager(): LiveData<Pager>

    @Query("SELECT * FROM pager_table LIMIT 1")
    suspend fun getPagerSync(): Pager?

    @Update
    suspend fun updatePager(pager: Pager)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPager(pager: Pager)
}