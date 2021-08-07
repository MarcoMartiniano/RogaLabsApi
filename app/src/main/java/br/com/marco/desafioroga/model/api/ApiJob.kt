package br.com.marco.desafioroga.model.api

import br.com.marco.desafioroga.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiJob {
    companion object{
        private var retrofit : Retrofit? = null

        val client:Retrofit get() {
        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
            return retrofit!!
        }
    }
}