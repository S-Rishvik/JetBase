package com.example.jetbase.di

import com.example.data.repository.GithubRepositoryImpl
import com.example.domain.repository.GithubRepository
import com.example.domain.source.GithubRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideGithubRepository(githubRemoteSource: GithubRemoteSource): GithubRepository {
        return GithubRepositoryImpl(githubRemoteSource)
    }
}
