package com.example.fighter_card_game.ui.auctionHouse

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fighter_card_game.model.Card

enum class Tier{
    BRONZE,
    SILVER,
    GOLD,
    PLATINUM,
    DIAMOND,
}

@Preview
@Composable
fun FighterCard(
    modifier: Modifier = Modifier.fillMaxSize(), card: Card = Card(
        1,
        "Rafs", "Lightweight", "Elite", "US", "Chubby", "10-0", "5'9", "23", "Islam Machachev", 99
    )
    ){
    var isFront by remember { mutableStateOf<Boolean>(true) }
    Box(
        modifier = modifier
            .background(
                when(card.tier){
                    "Bronze" -> Color(150, 88, 17)
                    "Silver" -> Color(194, 189, 178)
                    "Gold" -> Color(204, 146, 29)
                    "Elite"->Color(168, 50, 74)
                    else -> Color.White
                }
            )
            .clickable(
                onClick = { isFront = !isFront
                    Log.d("FighterCard", "FighterCard: ${isFront}")}

            ),
    ){
        if (isFront) {
            FrontCard(
                Modifier.fillMaxSize(1f).padding(10.dp),
                card
            )
        } else {
            BackCard(
                Modifier.fillMaxSize(.9f).padding(10.dp),
                card)
        }

    }
    }

@Composable
fun FrontCard(
    modifier: Modifier,
    card: Card
){
    Card(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(.1f)
                .fillMaxWidth()
                .padding(10.dp)
            ,
            contentAlignment = Alignment.TopEnd
        ){
            Text(text= card.overall.toString(), fontSize = 50.sp)
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(.9f)
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.Black)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth(1f),
            contentAlignment = Alignment.Center
        ){
            Text(text = card.nickname, fontSize = 50.sp)
        }

    }
}

@Composable
fun BackCard(
    modifier: Modifier,
    card: Card
){
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ){
        Text(text = "WeightClass: ${card.weightClass}", fontSize = 30.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Height: ${card.height}", fontSize = 30.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Age: ${card.age}", fontSize = 30.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Country: ${card.country}", fontSize = 30.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Next Fight: ${card.nextFight}", fontSize = 30.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Tier: ${card.tier}", fontSize = 30.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Record: ${card.record}", fontSize = 30.sp, modifier = Modifier.padding(10.dp))

    }

}
