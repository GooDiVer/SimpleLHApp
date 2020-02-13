package koin

import android.app.Application
import koin.KoinInitializer

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer.initKoinGraph(this)
    }
}