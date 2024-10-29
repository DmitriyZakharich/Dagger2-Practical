package com.example.core.models

import com.example.feature.home.models.Data2

data class Data2DTO(val string: String)

fun Data2DTO.toData2() = Data2(string = this.string)
