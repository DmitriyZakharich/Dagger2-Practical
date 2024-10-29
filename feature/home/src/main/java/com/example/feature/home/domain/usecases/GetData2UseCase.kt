package com.example.feature.home.domain.usecases

import com.example.feature.home.domain.models.Data2
import com.example.feature.home.domain.repository.Server2Loader
import javax.inject.Inject

class GetData2UseCase @Inject constructor(private val server2Loader: Server2Loader) {

    suspend fun execute(): Data2 = server2Loader.loadData()
}
