package com.example.leaguelegends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leaguelegends.ui.screens.ChampionDetail.ChampionDetailScreen
import com.example.leaguelegends.ui.screens.ChampionDetail.ChampionDetailViewModel
import com.example.leaguelegends.ui.screens.ChampionList.ChampionListScreen
import com.example.leaguelegends.ui.screens.ChampionList.ChampionListViewModel
import com.example.leaguelegends.ui.theme.LeagueLegendsTheme
import com.example.leaguelegends.util.ChampionDetails
import com.example.leaguelegends.util.ChampionList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeagueLegendsTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = ChampionList
                ){
                    composable<ChampionList> {
                        val viewModel = hiltViewModel<ChampionListViewModel>()

                        val state by viewModel.state.collectAsStateWithLifecycle()
                        ChampionListScreen(
                            state = state,
                            onValueChange = viewModel::onSearchTextChange,
                            navigate = { name ->
                               navController.navigate(ChampionDetails(name))
                            }
                        )
                    }
                    composable<ChampionDetails> {
                        val viewModel = hiltViewModel<ChampionDetailViewModel>()

                        viewModel.champion.value?.let {
                            ChampionDetailScreen(championModel = it)
                        }
                    }

                }

            }
        }
    }
}

