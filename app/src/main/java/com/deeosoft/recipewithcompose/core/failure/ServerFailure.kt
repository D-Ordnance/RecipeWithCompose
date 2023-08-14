package com.deeosoft.recipewithcompose.core.failure

class ServerFailure(message: String): Failure(message) {
    override fun getFormattedMessage(): String{
        return when(message){
            "An error occurred" -> "Something else"
            else -> "Another thing else"
        }
    }
}