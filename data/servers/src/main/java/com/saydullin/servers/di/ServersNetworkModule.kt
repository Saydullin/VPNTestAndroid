package com.saydullin.servers.di

import com.google.gson.Gson
import com.saydullin.servers.api.service.ServersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ServersNetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val okHttpsClient = OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
        }.build()

        return Retrofit.Builder()
            .client(okHttpsClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://restcountries.com/")
            .build()
    }

    @Provides
    fun provideServersService(retrofit: Retrofit): ServersService {
        return retrofit.create(ServersService::class.java)
    }

}