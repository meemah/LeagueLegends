package com.example.leaguelegends.ui.screens.ChampionDetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.leaguelegends.domain.model.ChampionModel
import com.example.leaguelegends.domain.model.toChampionList
import com.example.leaguelegends.domain.repository.ApiRepository
import com.example.leaguelegends.util.ChampionDetails
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionDetailViewModel @Inject constructor(
    private  val apiRepository: ApiRepository,
     private var savedStateHandle: SavedStateHandle
)

: ViewModel() {
    var champion = mutableStateOf<ChampionModel?>(null)
    init {
        val args = savedStateHandle.toRoute<ChampionDetails>()
        viewModelScope.launch {
            apiRepository.getChampionByName(args.name).onSuccess {
                champion.value = data.champion.values.firstOrNull()
            }
        }
    }

}