package com.example.feature.home.repository

import com.example.feature.home.models.Data2

interface Server2Loader {

    suspend fun loadData(): Data2?
}