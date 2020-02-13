package koin

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object KoinInitializer {
    fun initKoinGraph(applicationContext: Context) {
        startKoin {
            androidContext(applicationContext)
            androidLogger()

            modules(
                listOf(
                    ApiModule.module,
                    ViewModelModule.module
                )
            )
        }
    }
}