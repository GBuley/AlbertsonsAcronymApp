package com.example.albertsonsapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Var(
    val freq: Int,
    val lf: String,
    val since: Int
)