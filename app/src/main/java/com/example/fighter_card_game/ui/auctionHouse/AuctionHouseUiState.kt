package com.example.fighter_card_game.ui.auctionHouse

import com.example.fighter_card_game.model.AuctionHouseCards

sealed interface AuctionHouseUiState {
    data class Success(val auctionHouseCards: List<AuctionHouseCards>) : AuctionHouseUiState
    data class Error(val message: String) : AuctionHouseUiState
    object Loading : AuctionHouseUiState
}