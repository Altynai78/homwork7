package com.example.youtubeparccer

import android.app.Application
import com.example.youtubeparccer.di.koinModules

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(koinModules)
        }
    }
}