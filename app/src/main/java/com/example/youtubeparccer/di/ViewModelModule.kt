package com.example.youtubeparccer.di

import java.nio.file.Paths.get

val viewModelModule: Module = module {
    factory { DetailsViewModel(repository = get()) }
    factory { PlayerViewModel(repository = get()) }
    factory { PlaylistViewModel(repository = get()) }
