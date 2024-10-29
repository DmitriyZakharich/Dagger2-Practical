package com.example.dagger2practicalblock

import android.app.Application
import com.example.core.di.DaggerCoreComponent
import com.example.dagger2practicalblock.di.AppComponent
import com.example.dagger2practicalblock.di.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        val coreComponent = DaggerCoreComponent.builder().build()
        appComponent = DaggerAppComponent
            .builder().coreComponent(coreComponent)
            .build()
    }
}
