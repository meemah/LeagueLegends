package com.example.leaguelegends.ui.screens.ChampionList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leaguelegends.domain.model.toChampionList
import com.example.leaguelegends.domain.repository.ApiRepository
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChampionListViewModel @Inject constructor(
    private  val apiRepository: ApiRepository
): ViewModel() {

    init {
        viewModelScope.launch {
            apiRepository.getAllChampions()
                .onSuccess {
                    _state.update {
                        it.copy(
                            champions =data.champion.toChampionList()
                        )
                    }
                }
        }
    }

    private val _state = MutableStateFlow(ChampionListState())

    val  state =  _state.asStateFlow()

    fun  onSearchTextChange(text:String){
        _state.update {
            it.copy(
                searchText = text,
                filteredChampions = it.champions.filter {
                    championModel ->  championModel.name?.contains(
                        text, ignoreCase = true
                    )?:true
                }
            )
        }
    }



}