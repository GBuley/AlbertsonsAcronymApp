package com.example.albertsonsapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AcronymResponseItem(
    val lfs: List<Lf>,
    val sf: String
)