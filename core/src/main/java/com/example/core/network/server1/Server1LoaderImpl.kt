package com.example.core.network.server1

import com.example.core.BuildConfig
import com.example.core.di.Server1Qualifier
import com.example.core.models.toData1
import com.example.feature.home.models.Data1
import com.example.feature.home.repository.Server1Loader
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import javax.inject.Inject

class Server1LoaderImpl @Inject constructor(@Server1Qualifier val retrofit: Retrofit) : Server1Loader {

    override suspend fun loadData(): Data1 {
        return if (BuildConfig.DEBUG){
            delay(1000L)
            Data1("Test1")
        } else{
            val apiService1 = retrofit.create(ApiService1::class.java)
            val response = apiService1.getData()
            response.body()?.toData1() ?: throw Exception()
        }
    }
}
