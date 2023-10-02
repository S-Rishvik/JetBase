package com.example.jetbase.util

sealed class ViewState<out T> {
    data class Success<T>(val data: T) : ViewState<T>()
    object Loading : ViewState<Nothing>()
    object NoInternet : ViewState<Nothing>()
    data class Error(val message: String) : ViewState<Nothing>()
}
