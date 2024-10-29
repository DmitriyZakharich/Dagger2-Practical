package com.example.dagger2practicalblock

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.core.di.DaggerCoreComponent
import com.example.feature.home.di.DaggerFeatureComponent
import com.example.feature.home.di.FeatureComponent
import com.example.feature.home.presentation.CoreComponentProvider

class MyApp : Application(), CoreComponentProvider {

    override val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.builder().build()
    }
}
