package com.example.bitcoinprice.Retrofit

data class BitcoinResponse (
    val time: Time,
    val disclaimer: String,
    val chartName: String,
    val bpi: Bpi
)

data class Bpi (
    val USD: Moneda,
    val GBP: Moneda,
    val EUR: Moneda
)

data class Moneda (
    val code: String,
    val symbol: String,
    val rate: String,
    val description: String,
    val rateFloat: Double
)

data class Time (
    val updated: String,
    val updatedISO: String,
    val updateduk: String
)
