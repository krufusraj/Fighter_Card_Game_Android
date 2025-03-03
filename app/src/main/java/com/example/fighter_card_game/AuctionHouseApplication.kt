package com.example.fighter_card_game

import android.app.Application
import com.example.fighter_card_game.data.AppContainer
import com.example.fighter_card_game.data.DefaultAppContainer

class AuctionHouseApplication:Application() {
    lateinit var container: AppContainer
     override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}