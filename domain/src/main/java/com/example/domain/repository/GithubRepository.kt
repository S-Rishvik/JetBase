package com.example.domain.repository

import com.example.domain.entity.PullRequestEntity
import com.example.domain.requestmodel.PullRequest
import com.example.domain.util.SafeResult

interface GithubRepository {
  suspend fun getPullRequests(pullRequest: PullRequest): SafeResult<PullRequestEntity>
}