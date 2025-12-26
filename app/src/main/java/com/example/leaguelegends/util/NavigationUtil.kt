package com.example.leaguelegends.util

import kotlinx.serialization.Serializable


@Serializable
data object ChampionList

@Serializable
data class  ChampionDetails(val name: String)