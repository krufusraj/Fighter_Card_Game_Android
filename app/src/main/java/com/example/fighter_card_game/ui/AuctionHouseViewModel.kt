package com.example.fighter_card_game.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fighter_card_game.AuctionHouseApplication
import com.example.fighter_card_game.data.AuctionHouseRepository
import kotlinx.coroutines.launch

class AuctionHouseViewModel(
    private val auctionHouseRepository: AuctionHouseRepository
):ViewModel() {

    init {
        Log.d("AuctionHouseViewModel", "init: ")
        getAuctionHouseCards()
    }
    private fun  getAuctionHouseCards(){
        viewModelScope.launch {
            Log.d("AuctionHouseViewModel", "getAuctionHouseCards: ${auctionHouseRepository.getAuctionHouseCards()}")
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AuctionHouseApplication)
                val auctionHouseRepository = application.container.auctionHouseRepository
                AuctionHouseViewModel(auctionHouseRepository = auctionHouseRepository)
            }
        }
    }
}