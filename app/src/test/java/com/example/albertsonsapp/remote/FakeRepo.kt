package com.example.albertsonsapp.remote

import com.example.albertsonsapp.model.AcronymResponseItem
import com.example.albertsonsapp.model.Lf
import com.example.albertsonsapp.model.Var

object FakeRepo {
    private val myAcronymList = listOf(
        "api",
        "al",
        "ls",
        "si"
    )

    suspend fun getAcronym(acronym:String): List<AcronymResponseItem>? {
        return if(myAcronymList.contains(acronym)){
            listOf(AcronymResponseItem(
                listOf(
                    Lf(25, acronym, 1992, listOf(
                        Var(25, acronym, 1992),
                        Var(10, acronym, 1991))),
                    Lf(22, acronym, 1991, listOf(
                        Var(2, acronym, 1991)))
                ), "sf",
            ))
        } else{
            null
        }
    }
}