package com.jorch.mvvmsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    private val _progressVisibility = MutableLiveData<Boolean>()
    val progressVisibility: LiveData<Boolean> get() = _progressVisibility

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    fun onButtonClicked(user: String, password: String) = viewModelScope.launch {
        _progressVisibility.value = true
        _message.value = (withContext(Dispatchers.IO){
            delay(2000)
            if (user.isNotEmpty() && password.isNotEmpty()) "Success" else "Failure"
        })
        _progressVisibility.value = false
    }
}