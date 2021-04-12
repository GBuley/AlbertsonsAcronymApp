package com.example.albertsonsapp.remote

object Repo {

    suspend fun getAcronym(acronym: String) = RetrofitInstance.acronymService.getAcronym(acronym).run {
        if (isSuccessful) body() else null
    }

}