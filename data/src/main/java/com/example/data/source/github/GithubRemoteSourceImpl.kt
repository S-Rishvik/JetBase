package com.example.data.source.github

import com.example.data.mapper.PullRequestMapper
import com.example.data.remote.github.GithubApiService
import com.example.data.util.safeApiCall
import com.example.domain.entity.PullRequestEntity
import com.example.domain.requestmodel.PullRequest
import com.example.domain.source.GithubRemoteSource
import com.example.domain.util.SafeResult

class GithubRemoteSourceImpl(private val githubApiService: GithubApiService) : GithubRemoteSource {
    override suspend fun getRemotePullRequests(pullRequest: PullRequest): SafeResult<PullRequestEntity> {
        return safeApiCall {
            val mapper = PullRequestMapper()
            val response =
                githubApiService.getPullRequests(
                    pullRequest.owner,
                    pullRequest.repo,
                    pullRequest.state
                )
            mapper.map(response)
        }
    }
}
