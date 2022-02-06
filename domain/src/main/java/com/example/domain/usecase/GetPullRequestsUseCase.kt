package com.example.domain.usecase

import com.example.domain.entity.PullRequestEntity
import com.example.domain.repository.GithubRepository
import com.example.domain.requestmodel.PullRequest
import com.example.domain.util.BaseAsyncUseCase
import com.example.domain.util.SafeResult

class GetPullRequestsUseCase(private val githubRepository: GithubRepository): BaseAsyncUseCase<PullRequest,SafeResult<PullRequestEntity>> {
  override suspend fun performAsync(params: PullRequest): SafeResult<PullRequestEntity> {
    return githubRepository.getPullRequests(params)
  }
}