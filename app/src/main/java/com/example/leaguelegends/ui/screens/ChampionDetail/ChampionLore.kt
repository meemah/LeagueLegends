package com.example.leaguelegends.ui.screens.ChampionDetail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.leaguelegends.ui.theme.LeagueLegendsTheme

@Composable
fun ChampionLore(
    lore:String,
    modifier: Modifier = Modifier) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.clickable {
            isExpanded = !isExpanded
        }
    )
    {
        Text(text = "Lore",
        fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(text = lore,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = if(isExpanded)  Int.MAX_VALUE else  3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.animateContentSize ()
        )
        Text(text = if (isExpanded) "Show Less" else "Show More",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp)

            )

    }

}


@Preview
@Composable
fun ChampionLorePreview(modifier: Modifier = Modifier) {
    LeagueLegendsTheme {
        ChampionLore(lore = "Hello there is no lore on here ")
    }
}