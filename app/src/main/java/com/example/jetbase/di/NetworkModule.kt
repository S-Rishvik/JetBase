package com.example.jetbase.di

import com.example.data.remote.github.GithubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideGithubApiService(okHttpLoggingInterceptor: HttpLoggingInterceptor, gsonConverterFactory: GsonConverterFactory): GithubApiService {
        val retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(gsonConverterFactory)
                .client(OkHttpClient.Builder().addInterceptor(okHttpLoggingInterceptor).build())
                .build()
        return retrofit.create(GithubApiService::class.java)
    }
}
