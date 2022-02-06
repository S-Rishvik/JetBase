package com.example.data.util

import com.example.domain.util.SafeResult
import com.example.domain.util.SafeResult.Failure
import com.example.domain.util.SafeResult.NetworkError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

suspend fun <T> safeApiCall(
  dispatcher: CoroutineDispatcher=Dispatchers.IO,
  apiCall: suspend () -> T,
): SafeResult<T> {
  return withContext(dispatcher) {
    try {
      SafeResult.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
      Timber.e(throwable.message.toString())
      when (throwable) {
        is IOException -> NetworkError
        is HttpException -> Failure(exception = throwable, message = throwable.message())
        else -> Failure(Exception(throwable), throwable.message.orEmpty())
      }
    }
  }
}
