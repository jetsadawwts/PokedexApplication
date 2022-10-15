package com.jetsadawwts.pokedexapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jetsadawwts.pokedexapplication.pokemonlist.PokemonListScreen
import com.jetsadawwts.pokedexapplication.ui.theme.PokedexApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "pokemon_list_screen") {
                        composable("pokemon_list_screen") {
                            PokemonListScreen(navController = navController)
                        }
                        composable(
                            "pokemon_list_detail_screen/{dominantColor}/{pokemonName}",
                                arguments = listOf(
                                    navArgument("dominantColor") {
                                    type = NavType.IntType
                                },
                                navArgument("pokemonName") {
                                    type = NavType.StringType
                            }
                        )
                    ) {
                            val dominantColor = remember {
                                val color = it.arguments?.getInt("dominantColor")
                                color?.let { Color(it) } ?: Color.White
                            }

                            val pokemonName = remember {
                                it.arguments?.getString("pokemonName")
                            }
                        }
                }
            }
        }
    }
}

