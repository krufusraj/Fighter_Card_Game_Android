package com.example.fighter_card_game

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.fighter_card_game.ui.auctionHouse.AuctionHouse
import com.example.fighter_card_game.ui.auctionHouse.AuctionHouseViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate: ")
        setContent{
            Surface {
                AuctionHouse()
            }
        }


    }
}