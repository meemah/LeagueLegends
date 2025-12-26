package com.example.leaguelegends.ui.screens.ChampionDetail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.leaguelegends.domain.model.ChampionModel
import com.example.leaguelegends.domain.repository.ApiRepositoryImpl


@Composable
fun ChampionDetailScreen(modifier: Modifier = Modifier, championModel: ChampionModel) {
      Scaffold {
            paddingValues ->
                LazyColumn(modifier = Modifier.padding(paddingValues)) {
                    item { AsyncImage(
                            model = ApiRepositoryImpl.imageSplashUrl + "${championModel.name}_0.jpg",
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )

                        ChampionHeader(
                            championModel = championModel,
                            modifier = Modifier.padding(
                                horizontal = 10.dp,
                                vertical = 6.dp
                            )
                        )

                        ChampionLore(
                            lore = championModel.lore ?: "",
                            modifier = Modifier.padding(
                                horizontal = 20.dp,
                                vertical = 6.dp
                            )
                        )

                        championModel.passive?.let { passive ->
                            ChampionPassive(
                                passiveModel = passive,
                                modifier = Modifier.padding(
                                    horizontal = 6.dp,
                                    vertical = 10.dp
                                )
                            )
                        }

                        championModel.spells.forEach { spell ->
                            ChampionSpell(
                                spell = spell,
                                modifier = Modifier.padding(
                                    horizontal = 6.dp,
                                    vertical = 10.dp
                                )
                            )
                        }
                    }
                    }
                }



}