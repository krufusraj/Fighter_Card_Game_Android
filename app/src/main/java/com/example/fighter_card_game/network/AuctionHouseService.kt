package com.example.fighter_card_game.network

import com.example.fighter_card_game.model.AuctionHouseCards
import retrofit2.http.GET

interface AuctionHouseService {
    @GET("auction")
    suspend fun getAuctionHouseCards(): String

}