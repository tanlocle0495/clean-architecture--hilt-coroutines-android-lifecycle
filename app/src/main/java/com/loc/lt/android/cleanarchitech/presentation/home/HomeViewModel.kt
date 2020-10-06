package com.loc.lt.android.cleanarchitech.presentation.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.loc.lt.android.cleanarchitech.presentation.base.BaseViewModel
import com.loc.lt.android.cleanarchitech.utils.NetworkHelper

class HomeViewModel @ViewModelInject constructor(
//    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {

}