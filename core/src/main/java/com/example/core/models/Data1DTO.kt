package com.example.core.models

import com.example.feature.home.models.Data1

data class Data1DTO(val string: String)

fun Data1DTO.toData1() = Data1(string = this.string)
