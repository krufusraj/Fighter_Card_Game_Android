package com.example.fighter_card_game.model

import kotlinx.serialization.Serializable

@Serializable
data class Card(
   val cardId: Int,
   var name:String,
   var weightClass:String,
   var tier:String,
   var country:String,
   var nickname:String,
   var record:String,
   var height:String,
   var age:String,
   var nextFight:String,
   var overall:Int
)
