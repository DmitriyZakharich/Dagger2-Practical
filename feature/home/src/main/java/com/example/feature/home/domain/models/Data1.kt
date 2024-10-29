package com.example.feature.home.domain.models

import com.example.core.models.Data1DTO

data class Data1(val string: String)

fun Data1DTO.toData1() = Data1(string = this.string)
