package com.loc.lt.android.cleanarchitech.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {
    private val _isProgress: MutableLiveData<Boolean> by lazy {
        MutableLiveData(false)
    }

    fun setProgressbar(isProgress: Boolean) {
        this._isProgress.value = isProgress
    }

    val progress: LiveData<Boolean> get() = _isProgress
}