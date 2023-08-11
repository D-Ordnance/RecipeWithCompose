package com.deeosoft.recipewithcompose.core.response

sealed class BaseRemoteResponse<R>(
    val data: R? = null,
    val message: String? = null
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
    class Failure<R>(message: String): BaseRemoteResponse<R>(message = message)
}
