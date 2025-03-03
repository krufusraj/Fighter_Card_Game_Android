package com.example.fighter_card_game

import androidx.activity.viewModels
import com.example.fighter_card_game.ui.AuctionHouseViewModel
import org.junit.Test
import kotlin.getValue

class AuctionHouseViewModelTest {
    private val auctionHouseViewModel: AuctionHouseViewModel by viewModels { AuctionHouseViewModel.Factory }
}