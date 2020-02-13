package api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {
    private const val BASE_URL = "https://lifehacker.ru/"

    fun getInstance(moshiConverterFactory: MoshiConverterFactory): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(moshiConverterFactory)
        .build()
}