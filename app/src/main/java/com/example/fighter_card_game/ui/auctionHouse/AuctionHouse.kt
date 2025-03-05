package com.example.fighter_card_game.ui.auctionHouse

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AuctionHouse(
    auctionHouseUiState: AuctionHouseUiState
){
    Column {

        Row {  }
        AuctionHouseCards(auctionHouseUiState)
    }
}



@Composable
fun AuctionHouseCards(
    auctionHouseUiState: AuctionHouseUiState
) {
    when (auctionHouseUiState) {
        is AuctionHouseUiState.Success -> {
            val auctionHouseCards = auctionHouseUiState.auctionHouseCards
            val fighterCards = auctionHouseCards.map {
                FighterCard(
                    modifier = Modifier.width(20.dp).height(40.dp),
                    fighterCard = it.fighterCard
                )
            }
            LazyRow {
                fighterCards
            }

        }

        is AuctionHouseUiState.Error -> {
            Text("Error")
        }
        AuctionHouseUiState.Loading -> TODO()
    }
}