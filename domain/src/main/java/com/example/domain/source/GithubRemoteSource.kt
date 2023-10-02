package com.example.domain.source

import com.example.domain.entity.PullRequestEntity
import com.example.domain.requestmodel.PullRequest
import com.example.domain.util.SafeResult

interface GithubRemoteSource {
    suspend fun getRemotePullRequests(pullRequest: PullRequest): SafeResult<PullRequestEntity>
}
