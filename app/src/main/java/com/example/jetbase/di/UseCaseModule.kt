package com.example.jetbase.di

import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.GetPullRequestsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideGetPullRequestsUseCase(githubRepository: GithubRepository): GetPullRequestsUseCase {
        return GetPullRequestsUseCase(githubRepository)
    }
}
