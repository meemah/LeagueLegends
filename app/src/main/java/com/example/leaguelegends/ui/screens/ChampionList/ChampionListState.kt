package com.example.leaguelegends.ui.screens.ChampionList

import com.example.leaguelegends.domain.model.ChampionModel

data class ChampionListState(
    val searchText:String = "",
    val champions: List<ChampionModel> = emptyList(),
    val filteredChampions: List<ChampionModel> = emptyList()

)