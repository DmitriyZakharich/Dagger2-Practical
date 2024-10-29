package com.example.feature.home.repository

import com.example.feature.home.models.Data1

interface Server1Loader{

    suspend fun loadData(): Data1?
}
