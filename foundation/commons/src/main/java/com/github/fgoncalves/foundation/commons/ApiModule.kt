package com.github.fgoncalves.foundation.commons

import com.github.fgoncalves.foundation.commons.interceptors.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
interface ApiModule {
    companion object {
        @Provides
        @Reusable
        fun providesOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(ApiKeyInterceptor())
                .addInterceptor(HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                })
                .build()

        @Provides
        @Reusable
        fun providesRetrofit(
            okHttpClient: OkHttpClient,
        ): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}
