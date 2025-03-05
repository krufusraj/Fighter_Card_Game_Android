package com.example.fighter_card_game.model

import kotlinx.serialization.Serializable

@Serializable
data class FighterCard(
    private val cardId: Int,
    private var name:String,
    private var weightClass:String,
    private var tier:String,
    private var country:String,
    private var nickname:String,
    private var record:String,
    private var height:String,
    private var age:String,
    private var nextFight:String,
    private var overall:Int
)
