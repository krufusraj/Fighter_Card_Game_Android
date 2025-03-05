package com.example.fighter_card_game.ui.auctionHouse

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fighter_card_game.AuctionHouseApplication
import com.example.fighter_card_game.data.AuctionHouseRepository
import com.example.fighter_card_game.model.AuctionHouseCards
import kotlinx.coroutines.launch
import java.io.IOException

class AuctionHouseViewModel(
    private val auctionHouseRepository: AuctionHouseRepository
):ViewModel() {

    var auctionHouseUiState:AuctionHouseUiState = AuctionHouseUiState.Loading
        private set

    init {
        Log.d("AuctionHouseViewModel", "init: ")
        getAuctionHouseCards()
    }
    private fun  getAuctionHouseCards(){
        viewModelScope.launch {
            auctionHouseUiState = try {
                val auctionHouseCards:List<AuctionHouseCards> = auctionHouseRepository.getAuctionHouseCards()
                Log.d("AuctionHouseViewModel", "getAuctionHouseCards: ${auctionHouseCards}")
                AuctionHouseUiState.Success(auctionHouseCards)
            }
            catch (e: IOException){
                AuctionHouseUiState.Error(e.message.toString())
            }
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