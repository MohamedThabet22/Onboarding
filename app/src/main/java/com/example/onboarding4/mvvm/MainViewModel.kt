package com.example.onboarding4.mvvm

import android.app.Application
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.runtime.State
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.onboarding4.NavGraph.Screen

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val data: LiveData<Pager>

    private val repository: Repository
    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading


    init {
        val bookDao = PagerDatabase.getDatebase(application).bookDao()
        repository = Repository(bookDao)
        data = repository.DATA


    }

    fun updateOrCreateData(pager: Pager) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val existingPager = repository.getPager()
                if (existingPager != null) {
                    repository.update(pager)
                } else {
                    repository.insert(pager)
                }
                _isLoading.value = false
            } catch (e: Exception) {
                // التعامل مع الأخطاء هنا
            }
        }
    }
}