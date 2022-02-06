package com.example.data.repository

import com.example.domain.entity.PullRequestEntity
import com.example.domain.repository.GithubRepository
import com.example.domain.requestmodel.PullRequest
import com.example.domain.source.GithubRemoteSource
import com.example.domain.util.SafeResult

class GithubRepositoryImpl(private val githubRemoteSource: GithubRemoteSource): GithubRepository {
  override suspend fun getPullRequests(pullRequest: PullRequest): SafeResult<PullRequestEntity> {
    return githubRemoteSource.getRemotePullRequests(pullRequest)
  }
}