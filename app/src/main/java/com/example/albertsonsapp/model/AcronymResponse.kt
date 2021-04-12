package com.example.albertsonsapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AcronymResponse (
    val responseItem : List<AcronymResponseItem>
)