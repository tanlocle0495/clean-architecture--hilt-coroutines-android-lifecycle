package com.loc.lt.android.cleanarchitech.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.fragment.app.viewModels
import com.loc.lt.android.cleanarchitech.R
import com.loc.lt.android.cleanarchitech.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity(){
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun setupView() {
    }

    override fun setupObservable() {
    }
}