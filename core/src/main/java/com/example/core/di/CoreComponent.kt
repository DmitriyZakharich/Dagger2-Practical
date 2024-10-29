package com.example.core.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    @Server1Qualifier
    fun provideRetrofit1(): Retrofit

    @Server2Qualifier
    fun provideRetrofit2(): Retrofit
}
