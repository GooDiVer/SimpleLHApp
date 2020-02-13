package koin

import api.LHService
import api.RetrofitService
import api.WebProvider
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiModule {
    val module = module {

        single<MoshiConverterFactory> { MoshiConverterFactory.create(WebProvider.getMoshi()) }
        single<Retrofit> { RetrofitService.getInstance(moshiConverterFactory = get()) }
        single<LHService> { WebProvider.getLHService(retrofit = get()) }
    }
}