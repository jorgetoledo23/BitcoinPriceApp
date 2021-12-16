package com.example.bitcoinprice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bitcoinprice.Retrofit.APIService
import com.example.bitcoinprice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBitcoinPrice()


    }


    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.coindesk.com/v1/bpi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getBitcoinPrice(){
        CoroutineScope(Dispatchers.IO).launch {

            val call = getRetrofit().create(APIService::class.java)
                .getBitcoinPrice("currentprice.json")

            val resultado = call.body()

            runOnUiThread {

                if (resultado != null) {
                    binding.txtBitcoinPriceUSD.text = resultado.bpi.USD.rate.toString()
                    binding.txtBitcoinPriceGBP.text = resultado.bpi.GBP.rate.toString()
                    binding.txtBitcoinPriceEUR.text = resultado.bpi.EUR.rate.toString()
                }

            }

        }
    }


}