package com.example.dagger2practicalblock.di

import com.example.core.di.CoreComponent
import com.example.dagger2practicalblock.presentation.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [CoreComponent::class])
interface AppComponent {
    fun inject(mainFragment: MainFragment)
}
