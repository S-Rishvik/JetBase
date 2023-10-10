package com.example.jetbase.di

import com.example.data.remote.github.GithubApiService
import com.example.data.source.github.GithubRemoteSourceImpl
import com.example.domain.source.GithubRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    fun provide(githubApiService: GithubApiService): GithubRemoteSource {
        return GithubRemoteSourceImpl(githubApiService)
    }
}
