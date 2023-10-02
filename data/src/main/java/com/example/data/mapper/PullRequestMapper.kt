package com.example.data.mapper

import com.example.data.remote.github.PullRequestModel
import com.example.data.util.Mapper
import com.example.domain.entity.PullRequestEntity
import com.example.domain.entity.PullRequestEntity.PullRequestEntityItem

class PullRequestMapper : Mapper<PullRequestModel, PullRequestEntity> {
    override fun map(input: PullRequestModel): PullRequestEntity {
        val pullRequestEntity = PullRequestEntity()
        pullRequestEntity.addAll(
            input.map {
                PullRequestEntityItem(
                    title = it.title,
                    createdDate = it.createdAt,
                    closedDate = it.closedAt,
                    userName = it.user?.login,
                    userImageUrl = it.user?.avatarUrl,
                )
            },
        )
        return pullRequestEntity
    }
}
