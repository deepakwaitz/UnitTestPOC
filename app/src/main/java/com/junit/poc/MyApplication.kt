package com.junit.poc

import android.app.Application
import com.junit.poc.feature.main.repostitory.UserRepository
import com.junit.poc.feature.main.viewmodel.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * These modules are not tied to a user and should be initialized at application start up.
 */


val userModules = module {
    single { UserRepository() }
    viewModel { UserViewModel() }
}

@Suppress("unused")
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@MyApplication)
            modules(userModules)
        }
    }

    companion object {
        lateinit var instance: MyApplication
    }
}
