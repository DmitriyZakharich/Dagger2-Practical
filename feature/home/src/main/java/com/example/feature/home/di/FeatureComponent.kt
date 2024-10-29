package com.example.feature.home.di

import com.example.core.di.CoreComponent
import com.example.feature.home.domain.repository.Server1Loader
import com.example.feature.home.domain.repository.Server2Loader
import com.example.feature.home.presentation.FeatureFragment
import dagger.Component
import javax.inject.Scope

@FeatureScope
@Component(dependencies = [CoreComponent::class], modules = [FeatureModule::class])
interface FeatureComponent {
    fun provideServer1Loader(): Server1Loader
    fun provideServer2Loader(): Server2Loader

    fun inject(featureFragment: FeatureFragment)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope
