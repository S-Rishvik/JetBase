package com.example.jetbase.di

import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.GetPullRequestsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideGetPullRequestsUseCase(githubRepository: GithubRepository): GetPullRequestsUseCase {
        return GetPullRequestsUseCase(githubRepository)
    }
}
