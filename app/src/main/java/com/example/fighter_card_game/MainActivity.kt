package com.example.fighter_card_game

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import com.example.fighter_card_game.ui.AuctionHouseViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate: ")
        val auctionHouseViewModel: AuctionHouseViewModel by viewModels { AuctionHouseViewModel.Factory }
        auctionHouseViewModel.toString()

    }
}