package com.example.leaguelegends.ui.screens.ChampionDetail

import com.example.leaguelegends.domain.model.PassiveModel


import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

import com.example.leaguelegends.domain.repository.ApiRepositoryImpl


@Composable
fun ChampionPassive(modifier: Modifier = Modifier,passiveModel: PassiveModel) {
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(text = passiveModel.name?:"")
        },
        supportingContent = {
            Text(text = passiveModel.description ?: "")
        },
        leadingContent = {
            AsyncImage(
                model = ApiRepositoryImpl.imagePassiveUrl + "${passiveModel.image?.full}.png",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        },

        )

}