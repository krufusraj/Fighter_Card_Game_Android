package com.example.fighter_card_game.ui.auctionHouse

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fighter_card_game.model.FighterCard


@Composable
fun FighterCard(
    modifier:Modifier,
    fighterCard: FighterCard
){
    var isFront by remember { mutableStateOf<Boolean>(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clickable(
                onClick = { isFront = !isFront }
            ),
    ){
        if (isFront) {
            //FrontCard()
        } else {
            //BackCard()
        }

    }
    }

@Composable
fun FrontCard(
    modifier: Modifier
){
    Card(
        modifier = Modifier.fillMaxSize(1f)
    ) {
        //Image()
        //Text()
        //Text()
    }
}

@Composable
fun BackCard(
    modifier: Modifier
){
    Column(
        modifier = Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start

    ){

    }

}
