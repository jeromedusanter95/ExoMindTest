package com.jeromedusanter.exomindtest.di

import com.jeromedusanter.exomindtest.data.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetrofitModule(private val retrofit: Retrofit) {

    @Provides
    @Singleton
    internal fun provideRetrofit() = retrofit

    @Provides
    @Singleton
    internal fun provideDataService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}