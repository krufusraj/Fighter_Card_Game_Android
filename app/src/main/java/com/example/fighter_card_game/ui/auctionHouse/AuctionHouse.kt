package com.example.fighter_card_game.ui.auctionHouse

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fighter_card_game.R
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AuctionHouse(

){
    val auctionHouseViewModel: AuctionHouseViewModel = viewModel(factory = AuctionHouseViewModel.Factory)
    val auctionHouseUiState = auctionHouseViewModel.auctionHouseUiState
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
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
            Log.d("AuctionHouseCards", "${auctionHouseCards}")

            LazyRow (
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(auctionHouseCards) { auctionHouseCard ->
                    FighterCard(
                        modifier = Modifier.width(300.dp).height(600.dp),
                        card = auctionHouseCard.card
                    )
            }
//                fighterCards[0]
//                fighterCards[0]


//                items(fighterCards) { fighterCard ->
//                    fighterCard
//                }
            }

        }

        is AuctionHouseUiState.Error -> {
            Text("Error")
        }
        AuctionHouseUiState.Loading -> {
            Image(painter = painterResource(id = R.drawable.loading), contentDescription = "loading")
        }
    }
}