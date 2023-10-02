package com.example.jetbase.ui.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.PullRequestEntity
import com.example.domain.requestmodel.PullRequest
import com.example.domain.usecase.GetPullRequestsUseCase
import com.example.domain.util.SafeResult
import com.example.domain.util.SafeResult.Failure
import com.example.domain.util.SafeResult.NetworkError
import com.example.domain.util.SafeResult.Success
import com.example.jetbase.util.AppConstants
import com.example.jetbase.util.ViewState
import com.example.jetbase.util.ViewState.Error
import com.example.jetbase.util.ViewState.NoInternet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivityVM(private val getPullRequestsUseCase: GetPullRequestsUseCase) : ViewModel() {

    private val _pullRequestsLiveData =
        MutableStateFlow<ViewState<PullRequestEntity>>(ViewState.Loading)
    val pullRequestsLiveData: StateFlow<ViewState<PullRequestEntity>> = _pullRequestsLiveData

    fun getClosedPullRequests(owner: String, repo: String) = viewModelScope.launch {
        _pullRequestsLiveData.value = ViewState.Loading
        val result =
            getPullRequestsUseCase.performAsync(PullRequest(owner, repo, AppConstants.CLOSED_PULLS))
        _pullRequestsLiveData.value = handlePullRequestResult(result)
    }

    private fun handlePullRequestResult(result: SafeResult<PullRequestEntity>) =
        when (result) {
            is Failure -> Error(result.message)
            NetworkError -> NoInternet
            is Success -> ViewState.Success(result.data)
        }
}
