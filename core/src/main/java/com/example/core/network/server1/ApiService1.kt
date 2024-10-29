package com.example.core.network.server1

import com.example.core.models.Data1DTO
import retrofit2.Response

interface ApiService1 {

    suspend fun getData(): Response<Data1DTO>
}
