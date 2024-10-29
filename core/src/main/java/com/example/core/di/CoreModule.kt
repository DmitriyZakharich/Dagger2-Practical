package com.example.core.di

import com.example.core.utils.BASE_URL_SERVER_1
import com.example.core.utils.BASE_URL_SERVER_2
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class CoreModule {

    @Singleton
    @Provides
    @Server1Qualifier
    fun provideRetrofit1(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SERVER_1)
            .build()
    }

    @Singleton
    @Provides
    @Server2Qualifier
    fun provideRetrofit2(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SERVER_2)
            .build()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Server1Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Server2Qualifier
