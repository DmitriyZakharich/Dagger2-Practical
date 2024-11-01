package com.example.feature.home.di

import com.example.feature.home.domain.repository.Server1Loader
import com.example.feature.home.domain.repository.Server2Loader
import com.example.feature.home.repository.server1.Server1LoaderImpl
import com.example.feature.home.repository.server2.Server2LoaderImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureModule {

    @FeatureScope
    @Binds
    fun bindServer1Loader(
        server1LoaderImpl: Server1LoaderImpl
    ): Server1Loader

    @FeatureScope
    @Binds
    fun bindServer2Loader(
        server2LoaderImpl: Server2LoaderImpl
    ): Server2Loader
}
