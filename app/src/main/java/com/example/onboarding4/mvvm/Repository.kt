package com.example.onboarding4.mvvm

import androidx.lifecycle.LiveData
import com.example.onboarding4.mvvm.Pager
import com.example.onboarding4.mvvm.PagerDoa


class Repository(private val bookDao: PagerDoa) {
    val DATA: LiveData<Pager> = bookDao.getPager()

    suspend fun update(pager: Pager) {
        bookDao.updatePager(pager)
    }

    suspend fun insert(pager: Pager) {
        bookDao.insertPager(pager)
    }

    suspend fun getPager(): Pager? {
        return bookDao.getPagerSync()
    }
}
