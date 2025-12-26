package com.example.leaguelegends.ui.screens.ChampionList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.leaguelegends.domain.model.ChampionModel
import com.example.leaguelegends.domain.repository.ApiRepositoryImpl


@Composable
fun ChampionCard(
    modifier: Modifier = Modifier,
    championModel: ChampionModel
) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        AsyncImage(
            model = ApiRepositoryImpl.imageLoadingUrl + "${championModel.name}_0.jpg",
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .weight(0.3f)
                .height(180.dp)

        )
        Column (
            modifier = Modifier.weight(0.7f)
                .padding(vertical = 10.dp  )
        ){
            Text(text = championModel.name?:"N/A",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W700
            )
            Text(championModel.blurb?:"N/A",
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 24.sp

            )

        }
    }

}
