package com.example.leaguelegends.ui.screens.ChampionList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ChampionListScreen(
    state: ChampionListState,
    onValueChange: (String) -> Unit,
    navigate: (String) -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(
                innerPadding
            ).fillMaxWidth()
                .padding(horizontal = 20.dp )
        ) {
            OutlinedTextField(
                value = state.searchText,
                onValueChange = onValueChange,
                placeholder = {
                    Text("Search for Champs")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                    vertical = 20.dp
                )
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.filteredChampions.ifEmpty { state.champions }){
                 champion ->   ChampionCard(championModel = champion,
                    modifier = Modifier.animateItem()
                        .clickable { champion.name?.let(navigate)
                })
                }
            }
        }

    }

}




