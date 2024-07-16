package com.example.onboarding4.mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pager_table")
data class Pager(
    @PrimaryKey(autoGenerate = true ) val id: Int = 1,
    val isOnboardingComplete: Boolean // أضف هذه الخاصية

)