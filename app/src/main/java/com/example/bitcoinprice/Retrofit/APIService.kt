package com.example.bitcoinprice.Retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    suspend fun getBitcoinPrice(@Url url:String): Response<BitcoinResponse>



}