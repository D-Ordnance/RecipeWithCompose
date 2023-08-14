package com.deeosoft.recipewithcompose.core.response

import com.deeosoft.recipewithcompose.core.failure.Failure

sealed class BaseRemoteResponse<R>(
    val data: R? = null,
    val failure: Failure? = null
){
    class Success<R>(private var response: R): BaseRemoteResponse<R>(response){
        override fun equals(other: Any?): Boolean {
            if (other == null) return false
            if (this === other) return true
            if (other !is Success<*>) return false
            if (response != other.response) return false
            return true
        }

        override fun hashCode(): Int {
            return response?.hashCode() ?: 0
        }
    }
    class Error<R>(failure: Failure): BaseRemoteResponse<R>(failure = failure)
}
