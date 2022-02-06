package com.example.data.remote.github

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
  companion object{
    const val PATH_OWNER="owner"
    const val PATH_REPO="repo"
    const val END_POINT_GET_PULL_REQUEST="repos/{$PATH_OWNER}/{$PATH_REPO}/pulls"
  }

  @GET(END_POINT_GET_PULL_REQUEST)
  suspend fun getPullRequests(
    @Path(PATH_OWNER) owner: String,
    @Path(PATH_REPO) repo: String,
  ): PullRequestModel
}