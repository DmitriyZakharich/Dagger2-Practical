package com.example.core.network.server2

import android.util.Log
import com.example.core.BuildConfig
import com.example.core.di.Server2Qualifier
import com.example.core.models.toData2
import com.example.feature.home.models.Data2
import com.example.feature.home.repository.Server2Loader
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import javax.inject.Inject

class Server2LoaderImpl @Inject constructor(@Server2Qualifier val retrofit: Retrofit) :
    Server2Loader {

    override suspend fun loadData(): Data2 {
        return if (BuildConfig.DEBUG) {
            delay(1000L)
            Log.d("TAGeeee", "Server2LoaderImpl: loadData")
            Data2("Test2")
        } else {
            val apiService2 = retrofit.create(ApiService2::class.java)
            val response = apiService2.getData()
            response.body()?.toData2() ?: throw Exception()
        }
    }
}
