package com.example.data.remote.github

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {
    companion object {
        private const val BASE_URL = "https://api.github.com/"
        private const val PATH_OWNER = "owner"
        private const val PATH_REPO = "repo"
        private const val Query_STATE = "state"
        private const val END_POINT_GET_PULL_REQUEST = "repos/{$PATH_OWNER}/{$PATH_REPO}/pulls"

        fun getRetrofitService(): GithubApiService {
            val okHttpLoggingInterceptor by lazy {
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }
            val retrofit =
                Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().addInterceptor(okHttpLoggingInterceptor).build())
                    .build()
            return retrofit.create(GithubApiService::class.java)
        }
    }

    @GET(END_POINT_GET_PULL_REQUEST)
    suspend fun getPullRequests(
        @Path(PATH_OWNER) owner: String,
        @Path(PATH_REPO) repo: String,
        @Query(Query_STATE) state: String,
    ): PullRequestModel
}
