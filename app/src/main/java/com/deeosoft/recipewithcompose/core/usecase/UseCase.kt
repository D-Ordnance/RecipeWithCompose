package com.deeosoft.recipewithcompose.core.usecase

import com.deeosoft.recipewithcompose.core.response.BaseRemoteResponse

interface UseCase<P, R> {
    suspend fun execute(params: P): BaseRemoteResponse<R>
}