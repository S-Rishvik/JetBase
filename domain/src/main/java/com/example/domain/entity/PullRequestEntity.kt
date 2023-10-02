package com.example.domain.entity

import com.example.domain.entity.PullRequestEntity.PullRequestEntityItem

class PullRequestEntity : ArrayList<PullRequestEntityItem>() {
    data class PullRequestEntityItem(
        val title: String? = null,
        val createdDate: String? = null,
        val closedDate: String? = null,
        val userName: String? = null,
        val userImageUrl: String? = null,
    )
}
