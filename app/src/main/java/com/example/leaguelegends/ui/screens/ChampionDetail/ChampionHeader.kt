package com.example.leaguelegends.ui.screens.ChampionDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.leaguelegends.R
import com.example.leaguelegends.domain.model.ChampionModel
import com.example.leaguelegends.domain.repository.ApiRepositoryImpl
import com.example.leaguelegends.ui.theme.LeagueLegendsTheme

@Composable
fun ChampionHeader (modifier: Modifier = Modifier,
               championModel: ChampionModel
                    ) {
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(
                championModel.name?:"N/A",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

        },
        supportingContent = {
            Text(
                text = championModel.tags.firstOrNull()?:""
            )
        },
        leadingContent = {
            AsyncImage(
                model = ApiRepositoryImpl.imageSquareUrl + "${championModel.name}.png",
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        },
        trailingContent = {
            Text(
                text = championModel.title ?: "",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall

            )
        }
    )
}



