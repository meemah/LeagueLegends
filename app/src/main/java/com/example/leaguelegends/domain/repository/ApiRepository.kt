package com.example.leaguelegends.domain.repository

import com.example.leaguelegends.domain.model.ChampionResponseModel
import com.skydoves.sandwich.ApiResponse

interface ApiRepository {

    suspend fun getAllChampions() : ApiResponse<ChampionResponseModel>

    suspend fun getChampionByName(name:String) : ApiResponse<ChampionResponseModel>
}