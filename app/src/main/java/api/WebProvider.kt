package api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit

object WebProvider {

    fun getMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun getLHService(retrofit: Retrofit): LHService {
        return retrofit.create(LHService::class.java)
    }
}