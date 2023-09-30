package com.example.jetbase.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.remote.github.GithubApiService
import com.example.data.repository.GithubRepositoryImpl
import com.example.data.source.github.GithubRemoteSourceImpl
import com.example.domain.usecase.GetPullRequestsUseCase
import com.example.jetbase.ui.activity.main.MainActivityVM

class ViewModelFactory: ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    when (modelClass) {
      MainActivityVM::class.java -> {
        val githubRemoteSource = GithubRemoteSourceImpl(GithubApiService.getRetrofitService())
        val githubRepository = GithubRepositoryImpl(githubRemoteSource)
        val getPullRequestsUseCase = GetPullRequestsUseCase(githubRepository)
        return MainActivityVM(getPullRequestsUseCase) as T
      }

      else -> throw RuntimeException("ViewModel Not Found")
    }
  }
}