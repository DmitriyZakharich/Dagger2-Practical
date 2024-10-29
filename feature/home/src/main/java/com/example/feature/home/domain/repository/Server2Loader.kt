package com.example.feature.home.domain.repository

import com.example.feature.home.domain.models.Data2

interface Server2Loader {
    suspend fun loadData(): Data2
}
