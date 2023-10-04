package com.example.domain.util

interface BaseAsyncUseCase<in ExecutableParam, out Result> {

  /*
   If there is no input request model pass Unit generic type
   */
    suspend fun performAsync(params: ExecutableParam): Result
}
