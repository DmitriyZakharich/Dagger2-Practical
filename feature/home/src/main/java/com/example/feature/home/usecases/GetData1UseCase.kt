package com.example.feature.home.usecases

import com.example.feature.home.models.Data1
import com.example.feature.home.repository.Server1Loader
import javax.inject.Inject

class GetData1UseCase @Inject constructor(private val server1Loader: Server1Loader) {

    suspend fun execute(): Data1? = server1Loader.loadData()
}