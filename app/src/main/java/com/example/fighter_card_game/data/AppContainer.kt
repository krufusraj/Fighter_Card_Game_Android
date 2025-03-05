package com.example.fighter_card_game.data

import com.example.fighter_card_game.network.AuctionHouseService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

interface AppContainer {
    val auctionHouseRepository: AuctionHouseRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    private val baseUrl = "http://10.130.3.124:8081"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        //.addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: AuctionHouseService by lazy {
        retrofit.create(AuctionHouseService::class.java)
    }

    /**
     * DI implementation for Mars photos repository
     */
    override val auctionHouseRepository: AuctionHouseRepository by lazy {
        NetworkAuctionHouseRepository(retrofitService)
    }
}