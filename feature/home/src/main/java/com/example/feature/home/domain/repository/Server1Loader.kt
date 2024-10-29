package com.example.feature.home.domain.repository

import com.example.feature.home.domain.models.Data1

interface Server1Loader{
    suspend fun loadData(): Data1
}
