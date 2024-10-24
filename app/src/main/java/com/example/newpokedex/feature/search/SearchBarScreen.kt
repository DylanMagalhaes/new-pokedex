package com.example.newpokedex.feature.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.newpokedex.domain.model.Pokemon
import org.koin.androidx.compose.koinViewModel


@Composable
fun SearchBarScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonSearchViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    SearchBarScreen(
        modifier = modifier,
        onSearchInputChange = viewModel::onSearchInputChange,
        onSearchButtonClick = viewModel::onSearchButtonClicked,
        value = state.inputValue,
        pokemon = state.pokemon,
    )
}

@Composable
private fun SearchBarScreen(
    value: String,
    pokemon: Pokemon?,
    onSearchButtonClick: () -> Unit,
    onSearchInputChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextField(
                    value = value,
                    onValueChange = onSearchInputChange,
                )

                Spacer(modifier = Modifier.size(8.dp))

                IconButton(
                    onClick = onSearchButtonClick,
                    colors = IconButtonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            if (pokemon != null ){
                CardPokemon(pokemon)
            } else {
                Text(text = "no more pokemonuz")
            }

            Spacer(Modifier.weight(1f))
        }
    }

}

@Composable
fun CardPokemon(
    pokemon: Pokemon?,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .height(352.dp)
            .width(320.dp),
    )
    {
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            Row {
                Text(text = ("#" + pokemon?.id.toString()) ?: "No pokemon to show")

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = pokemon?.name ?: "No pokemon to show"
                    )
                }
            }
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(pokemon?.imageUrl),
                    contentDescription = null,
                    modifier = Modifier.size(256.dp)
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun Preview_Searchbar() {
    MaterialTheme {
        SearchBarScreen(
            modifier = Modifier.fillMaxSize(),
            onSearchButtonClick = {},
            onSearchInputChange = {},
            value = "",
            pokemon = Pokemon(
                name = "Pikachu",
                id = 1,
                imageUrl = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/62/regular.png"
            )
        )
    }
}