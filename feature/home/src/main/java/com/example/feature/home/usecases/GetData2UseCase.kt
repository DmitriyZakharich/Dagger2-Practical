package com.example.feature.home.usecases

import com.example.feature.home.models.Data2
import com.example.feature.home.repository.Server2Loader
import javax.inject.Inject

class GetData2UseCase @Inject constructor(private val server2Loader: Server2Loader) {

    suspend fun execute(): Data2? = server2Loader.loadData()
}