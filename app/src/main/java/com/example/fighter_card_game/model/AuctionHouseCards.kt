package com.example.fighter_card_game.model

import kotlinx.serialization.Serializable

@Serializable
data class AuctionHouseCards (
    val auctionHouseCardId: Int,
    val postedTime: String,
    val expirationTime: String,
    val card: Card,
    val buyNowPrice: Int,
    val bidAmount: Int,
    val duration: Int,
    val sellerId: Int,
    val maxBidderId: Int
)