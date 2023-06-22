package com.example.youtubeparccer.di

import com.example.youtubeparccer.core.network.networkModule

val koinModules = listOf(
    repositoryModule,
    networkModule,
    viewModelModule,

    )