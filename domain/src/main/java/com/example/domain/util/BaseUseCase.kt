package com.example.domain.util

interface BaseUseCase<in ExecutableParam, out Result> {

  /*
   If there is no input request model pass Unit generic type
   */
  fun perform(params: ExecutableParam): Result = throw NotImplementedError()
}
