package com.example.feature.home.domain.models

import com.example.core.models.Data2DTO

data class Data2(val string: String)

fun Data2DTO.toData2() = Data2(string = this.string)
