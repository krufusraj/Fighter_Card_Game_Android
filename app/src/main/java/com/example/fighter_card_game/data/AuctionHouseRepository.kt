package com.example.fighter_card_game.data

import com.example.fighter_card_game.model.AuctionHouseCards
import com.example.fighter_card_game.network.AuctionHouseService
import retrofit2.http.GET

interface AuctionHouseRepository {
    suspend fun getAuctionHouseCards(): List<AuctionHouseCards>;
}

class NetworkAuctionHouseRepository(
    private val auctionHouseService: AuctionHouseService
):AuctionHouseRepository{
    override suspend fun getAuctionHouseCards(): List<AuctionHouseCards>  = auctionHouseService.getAuctionHouseCards()
}