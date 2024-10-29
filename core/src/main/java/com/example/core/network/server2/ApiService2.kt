package com.example.core.network.server2

import com.example.core.models.Data2DTO
import retrofit2.Response

interface ApiService2 {

    suspend fun getData(): Response<Data2DTO>
}
