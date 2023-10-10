package com.example.drinker.common.di

import com.example.drinker.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {

    }

    viewModel {
        HomeViewModel()
    }
}