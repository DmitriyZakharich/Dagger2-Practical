package com.example.core.di

import com.example.core.network.server1.Server1LoaderImpl
import com.example.core.network.server2.Server2LoaderImpl
import com.example.core.network.utils.BASE_URL_SERVER_1
import com.example.core.network.utils.BASE_URL_SERVER_2
import com.example.feature.home.repository.Server1Loader
import com.example.feature.home.repository.Server2Loader
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module
class CoreRetrofitModule {

    @Provides
    @Server1Qualifier
    fun provideRetrofit1(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SERVER_1)
            .build()
    }

    @Provides
    @Server2Qualifier
    fun provideRetrofit2(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SERVER_2)
            .build()
    }
}

@Module
abstract class LoaderModule {

    @Binds
    abstract fun bindServer1Loader(
        server1LoaderImpl: Server1LoaderImpl
    ): Server1Loader

    @Binds
    abstract fun bindServer2Loader(
        server2LoaderImpl: Server2LoaderImpl
    ): Server2Loader
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Server1Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Server2Qualifier