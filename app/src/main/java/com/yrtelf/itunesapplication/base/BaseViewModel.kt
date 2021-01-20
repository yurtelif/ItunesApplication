package com.yrtelf.itunesapplication.base

import androidx.lifecycle.ViewModel
import com.yrtelf.itunesapplication.injection.DaggerViewModelInjector
import com.yrtelf.itunesapplication.injection.NetworkModule
import com.yrtelf.itunesapplication.injection.ViewModelInjector
import com.yrtelf.itunesapplication.ui.search.SearchViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is SearchViewModel -> injector.inject(this)
        }
    }
}