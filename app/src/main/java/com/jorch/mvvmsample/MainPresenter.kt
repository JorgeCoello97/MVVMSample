package com.jorch.mvvmsample

import kotlinx.coroutines.*

class MainPresenter(private val view: MainView, private val scope: CoroutineScope) {

    interface MainView {
        fun setProgressVisible(visible: Boolean)
        fun setMessage(message: String)
    }

    fun onButtonClicked(user: String, password: String) = scope.launch {
        view.setProgressVisible(true)
        view.setMessage(withContext(Dispatchers.IO){
            delay(2000)
            if (user.isNotEmpty() && password.isNotEmpty()) "Success" else "Failure"
        })
        view.setProgressVisible(false)
    }
}