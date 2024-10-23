package com.example.newpokedex.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SearchBarScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonSearchViewModel = viewModel()
){
    val state by viewModel.uiState.collectAsState()

}

@Composable
fun SearchBar(
    onSearchButtonClick: () -> Unit,
    value: String,
    onSearchInputChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
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
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White )
        }
    }
}




@Preview
@Composable
private fun Preview_Searchbar() {
    MaterialTheme{
        SearchBar(
            onSearchButtonClick = {},
            onSearchInputChange = {},
            value = ""
        )
    }
}