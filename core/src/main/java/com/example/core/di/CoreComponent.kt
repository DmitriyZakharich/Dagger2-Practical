package com.example.core.di

import com.example.feature.home.repository.Server1Loader
import com.example.feature.home.repository.Server2Loader
import dagger.Component
import retrofit2.Retrofit

//@CoreScope
@Component(modules = [CoreRetrofitModule::class, LoaderModule::class])
interface CoreComponent {
    fun provideServer1Loader(): Server1Loader
    fun provideServer2Loader(): Server2Loader

    @Server1Qualifier
    fun provideRetrofit1(): Retrofit

    @Server2Qualifier
    fun provideRetrofit2(): Retrofit

}

//@Scope
//@Retention(AnnotationRetention.RUNTIME)
//annotation class CoreScope