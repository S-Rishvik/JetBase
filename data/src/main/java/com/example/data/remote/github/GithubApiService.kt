package com.example.data.remote.github

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {
    companion object {
        private const val PATH_OWNER = "owner"
        private const val PATH_REPO = "repo"
        private const val Query_STATE = "state"
        private const val END_POINT_GET_PULL_REQUEST = "{$PATH_REPO}/pulls"
    }

    @GET(END_POINT_GET_PULL_REQUEST)
    suspend fun getPullRequests(
        @Path(PATH_REPO) repo: String,
        @Query(Query_STATE) state: String,
    ): PullRequestModel
}
