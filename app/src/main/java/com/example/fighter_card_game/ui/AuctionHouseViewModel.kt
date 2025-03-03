package com.example.fighter_card_game.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fighter_card_game.data.AuctionHouseRepository
import kotlinx.coroutines.launch

class AuctionHouseViewModel(
    private val auctionHouseRepository: AuctionHouseRepository
):ViewModel() {
    private fun  getAuctionHouseCards(){
        viewModelScope.launch {
            auctionHouseRepository.getAuctionHouseCards()
        }
    }
}